
package model.response.origami.debug;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class LayoutDebug {

    @SerializedName("MODULE_CLIENT_NOT_SUPPORTED")
    private List<MODULEDebug> mODULECLIENTNOTSUPPORTED;
    @SerializedName("MODULE_INACTIVE")
    private List<MODULEDebug> mODULEINACTIVE;
    @SerializedName("MODULE_NOT_SCHEDULE")
    private List<MODULEDebug> mODULENOTSCHEDULE;
    @SerializedName("MODULE_RENDERED")
    private List<MODULEDebug> mODULERENDERED;
    @SerializedName("MODULE_SECTION_LIMIT")
    private List<MODULEDebug> mODULESECTIONLIMIT;
    @SerializedName("MODULE_SEGMENT_UNMATCHED")
    private List<MODULEDebug> mODULESEGMENTUNMATCHED;
    @SerializedName("PAGE_LIMIT")
    private List<PAGELIMIT> pAGELIMIT;
    @SerializedName("PAGE_RENDERED")
    private List<PAGELIMIT> pAGERENDERED;
    @SerializedName("PAGE_SEGMENT_UNMATCHED")
    private List<PAGESEGMENTUNMATCHED> pAGESEGMENTUNMATCHED;
    @SerializedName("SECTION_RENDERED")
    private List<SECTIONRENDERED> sECTIONRENDERED;
}
