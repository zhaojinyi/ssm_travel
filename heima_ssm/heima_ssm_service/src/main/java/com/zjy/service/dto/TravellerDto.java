package com.zjy.service.dto;

import lombok.Data;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/28
 * @Description: com.zjy.service.dto
 */
@Data
public class TravellerDto {

    private String id;
    private String name;
    private String sex;
    private String phonenum;
    private Integer credentialstype;
    private String credentialstypestr;
    private String credentialsnum;
    private Integer travellertype;
    private String travellertypestr;

    public String getCredentialstypestr() {
        if(credentialstype != null){

            if(credentialstype == 0) {
                credentialstypestr = "身份证";
            }else if(credentialstype == 1) {
                credentialstypestr = "护照";
            } else if(credentialstype == 2) {
                credentialstypestr = "军官证";
            }
        }
        return credentialstypestr;
    }

    public void setCredentialstypestr(String credentialstypestr) {
        this.credentialstypestr = credentialstypestr;
    }

    public String getTravellertypestr() {
       if(travellertype != null){
           if(travellertype == 0) {
               travellertypestr = "成人";
           } else if(travellertype == 1){
               travellertypestr = "儿童";
           }
       }
        return travellertypestr;
    }

    public void setTravellertypestr(String travellertypestr) {
        this.travellertypestr = travellertypestr;
    }
}
