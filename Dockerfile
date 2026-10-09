FROM bellsoft/liberica-openjdk-alpine:21
RUN apk update && \
    apk add --no-cache ca-certificates && \
    update-ca-certificates

# # Set Java environment variables
# ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
# ENV PATH="$JAVA_HOME/bin:$PATH"

# Copy application JAR
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} test.jar

# Set Java options with temporary writable location for GC log and heap dump
#Add temp location for writing logs
# ENV JAVA_OPTS="\
#   -XX:+UseG1GC \
#   -XX:+UseStringDeduplication \
#   -XX:+HeapDumpOnOutOfMemoryError \
#   -XX:HeapDumpPath=/tmp/java_heapdump.hprof \
#   -Xlog:gc*:file=/tmp/gc.log:tags,level,uptime \
#   -Dhttps.protocols=TLSv1.2,TLSv1.3 \
#   -Djdk.tls.client.protocols=TLSv1.2,TLSv1.3"

# # Start the application
# ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar test.jar"]
