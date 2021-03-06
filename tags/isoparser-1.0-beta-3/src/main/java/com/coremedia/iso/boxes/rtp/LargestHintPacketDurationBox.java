package com.coremedia.iso.boxes.rtp;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoBufferWrapper;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoOutputStream;
import com.coremedia.iso.boxes.AbstractBox;
import com.coremedia.iso.boxes.Box;

import java.io.IOException;

/**
 * The largest packet, in bytes; includes 12-byte RTP header.
 */
public class LargestHintPacketDurationBox extends AbstractBox {
    public static final String TYPE = "dmax";

    long milliSeconds;

    public LargestHintPacketDurationBox() {
        super(IsoFile.fourCCtoBytes(TYPE));
    }

    protected long getContentSize() {
        return 4;
    }

    public void parse(IsoBufferWrapper in, long size, BoxParser boxParser, Box lastMovieFragmentBox) throws IOException {
        milliSeconds = in.readUInt32();
    }

    public String getDisplayName() {
        return "Largest Hint Packet Duration";
    }

    protected void getContent(IsoOutputStream os) throws IOException {
        os.writeUInt32(milliSeconds);
    }

    public long getMilliSeconds() {
        return milliSeconds;
    }

    public void setMilliSeconds(long milliSeconds) {
        this.milliSeconds = milliSeconds;
    }
}
