/*************************************************
 * MailerSend Java SDK
 * https://github.com/mailersend/mailersend-java
 * 
 * @author MailerSend <support@mailersend.com>
 * https://mailersend.com
 **************************************************/
package com.mailersend.sdk.recipients;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

/**
 * <p>BlocklistItem class.</p>
 *
 * @author mailersend
 * @version $Id: $Id
 */
public class BlocklistItem {

    @SerializedName("id")
    public String id;
    
    @SerializedName("type")
    public String type;
    
    @SerializedName("pattern")
    public String pattern;
    
    @SerializedName("domain")
    public BlocklistDomain domain;
    
    @SerializedName("created_at")
    private String createdAtString;
    
    @SerializedName("updated_at")
    private String updatedAtString;
    
    public Date createdAt;
    
    public Date updatedAt;
    
    
    /**
     * Converts the retrieved dates to java.util.Date
     */
    protected void parseDates() {
        
        TemporalAccessor ta;
        Instant instant;
        
        if (createdAtString != null && !createdAtString.isBlank()) {
            
            ta = DateTimeFormatter.ISO_INSTANT.parse(createdAtString);
            instant = Instant.from(ta);
            createdAt = Date.from(instant);
        }
        
        if (updatedAtString != null && !updatedAtString.isBlank()) {
            
            ta = DateTimeFormatter.ISO_INSTANT.parse(updatedAtString);
            instant = Instant.from(ta);
            updatedAt = Date.from(instant);
        }
        
        if (domain != null) {
        
            domain.parseDates();
        }
    }
}
