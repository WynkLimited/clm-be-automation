node('disco-prd-slave'){
    env.deployment_environment="prod"
    env.JAVA_HOME="/opt/JavaVersions/jdk-21.0.1"
    env.MAVEN_HOME = "/opt/MavenVersions/apache-maven-3.9.8/bin/"
    env.PATH="$JAVA_HOME/bin/:$MAVEN_HOME:$PATH"
    env.service_name="cucumber-automation"
    env.docker_registry='asia-south1-docker.pkg.dev'
    env.imagename="prd-disco-cucumber-automation"
    
    def TIME_OF_BUILD = Calendar.getInstance().getTime().format('YYYY_MM_dd-HH_mm_ss', TimeZone.getTimeZone('IST'))
    def BUILD_SUCCESS = true
    try {
        stage('Clean'){
            sh """
              sudo rm -rf *
             """
        }
        
        stage('Git Clone') {
            git branch: "$BRANCH_NAME", credentialsId: 'wynkdeployment', url: 'https://github.com/WynkLimited/discovery-automation-test.git'
        }
        
        
        
        stage('Build') {
            sh """
                mvn test -Dcucumber.filter.tags="${TAGS}" -Denv="${APP_ENV}"
                docker build -t "$docker_registry"/"${GCP_PROJECT}"/"$imagename"/${TIME_OF_BUILD}:${TIME_OF_BUILD} -f Dockerfile .
            """
        }

        // stage('Run JAR') {
        //     sh """
        //         java -jar target/LayoutAPI-1.0-SNAPSHOT.jar
        //     """
        // }
     
        
        
        stage('Docker Push') {
            sh """
                gcloud auth configure-docker ${GCP_REGION}
                docker login "$docker_registry"/"${GCP_PROJECT}"/"$imagename"
                docker push "$docker_registry"/"${GCP_PROJECT}"/"$imagename"/${TIME_OF_BUILD}:${TIME_OF_BUILD}  
            """
        }
        
        stage('Deployment Pipeline') {
            build job: "$CD_DEPLOYMENT_PIPELINE",
                        parameters: [[$class: 'StringParameterValue', name: 'APP_ENV', value: "${deployment_environment}"],
                                     [$class: 'StringParameterValue', name: 'SERVICE_NAME', value: "${service_name}"],
                                     [$class: 'StringParameterValue', name: 'IMAGE_REPO', value: "${docker_registry}\\/${GCP_PROJECT}\\/${imagename}\\/${TIME_OF_BUILD}"],
                                     [$class: 'StringParameterValue', name: 'IMAGE_TAG', value: "${TIME_OF_BUILD}"]],
                        wait: true
        }
        
        stage('Clean Up') {
            sh """
                rm -rf *
            """
        }
    }
    catch (error) {
        BUILD_SUCCESS = false
        currentBuild.result = 'FAILURE'
    }
    finally {
        if (BUILD_SUCCESS) {
            slackSend channel: '#discovery-gcp-jenkins-build', botUser: true, color: 'good', message: "[SUCCESS] ${env.BUILD_USER} triggered ${env.JOB_NAME}-${env.BUILD_NUMBER} \nURL: ${env.BUILD_URL} \nParameters: ${params}"
        }
        else {
            slackSend channel: '#discovery-gcp-jenkins-build', botUser: true, color: 'danger', message: "[FAILURE] ${env.BUILD_USER} triggered ${env.JOB_NAME}-${env.BUILD_NUMBER} \nURL: ${env.BUILD_URL} \nParameters: ${params}"
        }
    }
}
