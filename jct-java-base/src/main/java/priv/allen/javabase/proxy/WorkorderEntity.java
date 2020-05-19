/*
 * Delta CONFIDENTIAL
 *
 * (C) Copyright Delta Electronics, Inc. 2015 All Rights Reserved
 *
 * NOTICE:  All information contained herein is, and remains the
 * property of Delta Electronics. The intellectual and technical
 * concepts contained herein are proprietary to Delta Electronics
 * and are protected by trade secret, patent law or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Delta Electronics.
 */
package priv.allen.javabase.proxy;

/**
 * 
 * @author V.Mengqi.Hu
 * @date 2018-05-15
 * @version 1.0
 */
public class WorkorderEntity {
	
	private Integer id;
	private String workorder;
	private Integer productId;
	
	private String productName;
	
	private String side;
	
	private Integer poId;
	
	private String poNo;
	private String lineName;
	private String type;
	
	private String status;
	private Integer qty;
	
	private Integer currentQty;
	private String onlineTimePlan;
	
	private String onlineTimeActual;
	private String offlineTimePlan;
	
	private String offlineTimeActual;
	
	private Integer serialId;
	
	private String active;
	
	private String createBy;
	
	private String createDate;
	
	private String lastUpdateBy;
	
	private String lastUpdateDate;
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WorkorderEntity [id=" + id + ", workorder=" + workorder + ", productId=" + productId + ", productName="
				+ productName + ", side=" + side + ", poId=" + poId + ", poNo=" + poNo + ", lineName=" + lineName
				+ ", type=" + type + ", status=" + status + ", qty=" + qty + ", currentQty=" + currentQty
				+ ", onlineTimePlan=" + onlineTimePlan + ", onlineTimeActual=" + onlineTimeActual + ", offlineTimePlan="
				+ offlineTimePlan + ", offlineTimeActual=" + offlineTimeActual + ", serialId=" + serialId + ", active="
				+ active + ", createBy=" + createBy + ", createDate=" + createDate + ", lastUpdateBy=" + lastUpdateBy
				+ ", lastUpdateDate=" + lastUpdateDate + "]";
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the workorder
	 */
	public String getWorkorder() {
		return workorder;
	}

	/**
	 * @param workorder the workorder to set
	 */
	public void setWorkorder(String workorder) {
		this.workorder = workorder;
	}

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the side
	 */
	public String getSide() {
		return side;
	}

	/**
	 * @param side the side to set
	 */
	public void setSide(String side) {
		this.side = side;
	}

	/**
	 * @return the poId
	 */
	public Integer getPoId() {
		return poId;
	}

	/**
	 * @param poId the poId to set
	 */
	public void setPoId(Integer poId) {
		this.poId = poId;
	}

	/**
	 * @return the poNo
	 */
	public String getPoNo() {
		return poNo;
	}

	/**
	 * @param poNo the poNo to set
	 */
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	/**
	 * @return the lineName
	 */
	public String getLineName() {
		return lineName;
	}

	/**
	 * @param lineName the lineName to set
	 */
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the qty
	 */
	public Integer getQty() {
		return qty;
	}

	/**
	 * @param qty the qty to set
	 */
	public void setQty(Integer qty) {
		this.qty = qty;
	}

	/**
	 * @return the currentQty
	 */
	public Integer getCurrentQty() {
		return currentQty;
	}

	/**
	 * @param currentQty the currentQty to set
	 */
	public void setCurrentQty(Integer currentQty) {
		this.currentQty = currentQty;
	}

	/**
	 * @return the onlineTimePlan
	 */
	public String getOnlineTimePlan() {
		return onlineTimePlan;
	}

	/**
	 * @param onlineTimePlan the onlineTimePlan to set
	 */
	public void setOnlineTimePlan(String onlineTimePlan) {
		this.onlineTimePlan = onlineTimePlan;
	}

	/**
	 * @return the onlineTimeActual
	 */
	public String getOnlineTimeActual() {
		return onlineTimeActual;
	}

	/**
	 * @param onlineTimeActual the onlineTimeActual to set
	 */
	public void setOnlineTimeActual(String onlineTimeActual) {
		this.onlineTimeActual = onlineTimeActual;
	}

	/**
	 * @return the offlineTimePlan
	 */
	public String getOfflineTimePlan() {
		return offlineTimePlan;
	}

	/**
	 * @param offlineTimePlan the offlineTimePlan to set
	 */
	public void setOfflineTimePlan(String offlineTimePlan) {
		this.offlineTimePlan = offlineTimePlan;
	}

	/**
	 * @return the offlineTimeActual
	 */
	public String getOfflineTimeActual() {
		return offlineTimeActual;
	}

	/**
	 * @param offlineTimeActual the offlineTimeActual to set
	 */
	public void setOfflineTimeActual(String offlineTimeActual) {
		this.offlineTimeActual = offlineTimeActual;
	}

	/**
	 * @return the serialId
	 */
	public Integer getSerialId() {
		return serialId;
	}

	/**
	 * @param serialId the serialId to set
	 */
	public void setSerialId(Integer serialId) {
		this.serialId = serialId;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}

	/**
	 * @return the createBy
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * @param createBy the createBy to set
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the lastUpdateBy
	 */
	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	/**
	 * @param lastUpdateBy the lastUpdateBy to set
	 */
	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	/**
	 * @return the lastUpdateDate
	 */
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentQty == null) ? 0 : currentQty.hashCode());
		result = prime * result + ((lineName == null) ? 0 : lineName.hashCode());
		result = prime * result + ((offlineTimeActual == null) ? 0 : offlineTimeActual.hashCode());
		result = prime * result + ((offlineTimePlan == null) ? 0 : offlineTimePlan.hashCode());
		result = prime * result + ((onlineTimeActual == null) ? 0 : onlineTimeActual.hashCode());
		result = prime * result + ((onlineTimePlan == null) ? 0 : onlineTimePlan.hashCode());
		result = prime * result + ((poId == null) ? 0 : poId.hashCode());
		result = prime * result + ((poNo == null) ? 0 : poNo.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((qty == null) ? 0 : qty.hashCode());
		result = prime * result + ((side == null) ? 0 : side.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((workorder == null) ? 0 : workorder.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkorderEntity other = (WorkorderEntity) obj;
		if (currentQty == null) {
			if (other.currentQty != null)
				return false;
		} else if (!currentQty.equals(other.currentQty))
			return false;
		if (lineName == null) {
			if (other.lineName != null)
				return false;
		} else if (!lineName.equals(other.lineName))
			return false;
		if (offlineTimeActual == null) {
			if (other.offlineTimeActual != null)
				return false;
		} else if (!offlineTimeActual.equals(other.offlineTimeActual))
			return false;
		if (offlineTimePlan == null) {
			if (other.offlineTimePlan != null)
				return false;
		} else if (!offlineTimePlan.equals(other.offlineTimePlan))
			return false;
		if (onlineTimeActual == null) {
			if (other.onlineTimeActual != null)
				return false;
		} else if (!onlineTimeActual.equals(other.onlineTimeActual))
			return false;
		if (onlineTimePlan == null) {
			if (other.onlineTimePlan != null)
				return false;
		} else if (!onlineTimePlan.equals(other.onlineTimePlan))
			return false;
		if (poId == null) {
			if (other.poId != null)
				return false;
		} else if (!poId.equals(other.poId))
			return false;
		if (poNo == null) {
			if (other.poNo != null)
				return false;
		} else if (!poNo.equals(other.poNo))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (qty == null) {
			if (other.qty != null)
				return false;
		} else if (!qty.equals(other.qty))
			return false;
		if (side == null) {
			if (other.side != null)
				return false;
		} else if (!side.equals(other.side))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (workorder == null) {
			if (other.workorder != null)
				return false;
		} else if (!workorder.equals(other.workorder))
			return false;
		return true;
	}
	
	
}
