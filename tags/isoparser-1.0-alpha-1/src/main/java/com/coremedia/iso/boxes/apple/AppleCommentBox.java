package com.coremedia.iso.boxes.apple;

import com.coremedia.iso.Utf8;

/**
 * itunes MetaData comment box.
 */
public final class AppleCommentBox extends AbstractAppleMetaDataBox {
  public static final String TYPE = "\u00a9cmt";


  public AppleCommentBox() {
    super(TYPE);
  }

  public String getDisplayName() {
    return "iTunes Comment";
  }


  public void setComment(String comment) {
    appleDataBox = new AppleDataBox();
    appleDataBox.setVersion(0);
    appleDataBox.setFlags(1);
    appleDataBox.setFourBytes(new byte[4]);
    appleDataBox.setContent(Utf8.convert(comment));
  }

  public String getComment() {
    return Utf8.convert(appleDataBox.getContent());
  }
}
