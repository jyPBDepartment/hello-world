package com.jy.pc.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="sas_agricultural_clothing_info")
public class AgriculturalEntity {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(strategy = "uuid", name = "uuid")
	@Column(length=36)
	private String id;//主键id
	@Column(length=255)
	private String name;//标题名称
	@Column
	private String descrip;//描述
	@Column(length=8)
	private String transactionTypeCode;//农服交易类型
	@Column(length=8)
	private String transactionCategoryCode;//农服交易类别
	@Column
	private float purchasingPrice;//收购价格
	@Column(length=255)
	private String purchasingArea;//收购区域
	@Column
	private float sellingPrice;//出售价格
	@Column(length=255)
	private String sellingArea;//出售区域
	@Column(length=255)
	private String contactsUser;//联系人
	@Column(length=255)
	private String contactsPhone;//联系方式
	@Column
	private String url;//图片
	@Column(length=255)
	private String classiCode;//机器类型
	
	@Column(length=8)
	private String machineType;//机器类型
	@Column(length=255)
	private String model;//型号
	@Column(length=255)
	private String articleNumber;//货号
	@Column(length=255)
	private String labelCode;//标签编码
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
	private Date purchaseDate;//购买时间
	@Column(length=1)
	private String status;//状态
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
	private Date createDate;//发布时间
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;//修改时间
	@Column(length=255)
	private String createUser;//发布人
	@Column(length=255)
	private String updateUser;//审核人
	@Column(length=255)
	private String examineReason;//审核拒绝理由
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getTransactionTypeCode() {
		return transactionTypeCode;
	}
	public void setTransactionTypeCode(String transactionTypeCode) {
		this.transactionTypeCode = transactionTypeCode;
	}
	public String getTransactionCategoryCode() {
		return transactionCategoryCode;
	}
	public void setTransactionCategoryCode(String transactionCategoryCode) {
		this.transactionCategoryCode = transactionCategoryCode;
	}
	public float getPurchasingPrice() {
		return purchasingPrice;
	}
	public void setPurchasingPrice(float purchasingPrice) {
		this.purchasingPrice = purchasingPrice;
	}
	public String getPurchasingArea() {
		return purchasingArea;
	}
	public void setPurchasingArea(String purchasingArea) {
		this.purchasingArea = purchasingArea;
	}
	public float getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getSellingArea() {
		return sellingArea;
	}
	public void setSellingArea(String sellingArea) {
		this.sellingArea = sellingArea;
	}
	public String getContactsUser() {
		return contactsUser;
	}
	public void setContactsUser(String contactsUser) {
		this.contactsUser = contactsUser;
	}
	public String getContactsPhone() {
		return contactsPhone;
	}
	public void setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMachineType() {
		return machineType;
	}
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getArticleNumber() {
		return articleNumber;
	}
	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}
	public String getLabelCode() {
		return labelCode;
	}
	public void setLabelCode(String labelCode) {
		this.labelCode = labelCode;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getExamineReason() {
		return examineReason;
	}
	public void setExamineReason(String examineReason) {
		this.examineReason = examineReason;
	}
	public String getClassiCode() {
		return classiCode;
	}
	public void setClassiCode(String classiCode) {
		this.classiCode = classiCode;
	}
	
	
}