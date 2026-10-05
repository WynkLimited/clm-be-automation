
package model.response.origami.debug;

import lombok.Data;
import com.google.gson.annotations.Expose;

@Data
public class DISPLAY {
    private String gradientColorDarkEnd;
    private String gradientColorDarkStart;
    private String gradientColorEnd;
    private String gradientColorStart;
    private String img;
    private String imgDark;
    private Long imgHeight;
    private Long imgWidth;
    private Boolean isHT;
    private Long itemCnt;
    private String leftIcons;
    private Long minCnt;
    private String moreColor;
    private String moreColorDark;
    private String moreTxt;
    private String rightIcons;
    private Boolean showSearchExpanded;
    private Long subTitleBoldRange;
    private Long subTitleSize;
    private Long titleBoldRange;
    private String titleColor;
    private String titleColorDark;
    private String titleOverrideText;
    private String titleTxt;
}
