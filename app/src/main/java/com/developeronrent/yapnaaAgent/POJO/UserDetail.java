package com.developeronrent.yapnaaAgent.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDetail {

    @SerializedName("admin_id")
    @Expose
    private String adminId;
    @SerializedName("admin_name")
    @Expose
    private String adminName;
    @SerializedName("admin_email_id")
    @Expose
    private String adminEmailId;
    @SerializedName("admin_password")
    @Expose
    private String adminPassword;
    @SerializedName("admin_last_login")
    @Expose
    private String adminLastLogin;
    @SerializedName("admin_role_id")
    @Expose
    private String adminRoleId;
    @SerializedName("admin_phone_no")
    @Expose
    private String adminPhoneNo;
    @SerializedName("admin_address")
    @Expose
    private String adminAddress;
    @SerializedName("admin_fcm_id")
    @Expose
    private String adminFcmId;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmailId() {
        return adminEmailId;
    }

    public void setAdminEmailId(String adminEmailId) {
        this.adminEmailId = adminEmailId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminLastLogin() {
        return adminLastLogin;
    }

    public void setAdminLastLogin(String adminLastLogin) {
        this.adminLastLogin = adminLastLogin;
    }

    public String getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(String adminRoleId) {
        this.adminRoleId = adminRoleId;
    }

    public String getAdminPhoneNo() {
        return adminPhoneNo;
    }

    public void setAdminPhoneNo(String adminPhoneNo) {
        this.adminPhoneNo = adminPhoneNo;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }

    public String getAdminFcmId() {
        return adminFcmId;
    }

    public void setAdminFcmId(String adminFcmId) {
        this.adminFcmId = adminFcmId;
    }

    @Override
    public String toString() {
        return ("adminId" + adminId + "adminName" + adminName +
                "adminEmailId" + adminEmailId + "adminPassword" + adminPassword + "adminLastLogin" +
                adminLastLogin + "adminRoleId" + adminRoleId + "adminPhoneNo" + adminPhoneNo + "adminAddress"
                + adminAddress + "adminFcmId" + adminFcmId);
    }
}
