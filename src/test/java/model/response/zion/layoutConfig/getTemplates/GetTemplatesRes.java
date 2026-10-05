
package model.response.zion.layoutConfig.getTemplates;

import java.util.List;
import lombok.Data;

import com.google.gson.annotations.SerializedName;

@Data
public class GetTemplatesRes {

    @SerializedName("ADVERTISEMENT")
    private List<ADVERTISEMENT> aDVERTISEMENT;
    @SerializedName("AS")
    private List<A> aS;
    private List<A> as;
    private List<Asdwd> asdwd;
    @SerializedName("Benefits")
    private List<Benefit> benefits;
    @SerializedName("CONTENT")
    private List<CONTENT> cONTENT;
    @SerializedName("Car")
    private List<Car> car;
    @SerializedName("FAB_BUTTON")
    private List<FABBUTTON> fABBUTTON;
    @SerializedName("HT")
    private List<HT> hT;
    @SerializedName("My Library")
    private List<MyLibrary> myLibrary;
    @SerializedName("NONE")
    private List<NONE> nONE;
    @SerializedName("Navigation")
    private List<Navigation> navigation;
    @SerializedName("Onboarding")
    private List<Onboarding> onboarding;
    @SerializedName("PODCAST")
    private List<PODCAST> pODCAST;
    @SerializedName("RADIO")
    private List<RADIO> rADIO;
    private List<Sa> sas;
    @SerializedName("Test")
    private List<Test> test;
    @SerializedName("TestLabel")
    private List<TestLabel> testLabel;
    @SerializedName("Thanks Discover")
    private List<ThanksDiscover> thanksDiscover;
}
