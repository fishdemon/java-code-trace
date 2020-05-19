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

import java.util.List;

/**
 * 
 * @author V.Mengqi.Hu
 * @date 2018-05-15
 * @version 1.0
 */
public interface WorkorderDao {
	/**
	 * 
	 * @param params
	 * @return int
	 * @throws Exception
	 */
	int saveWorkorder(WorkorderEntity entity) throws Exception;
	/**
	 * 
	 * @param params
	 * @return int
	 * @throws Exception
	 */
	int updateWorkorder(WorkorderEntity entity) throws Exception;
	/**
	 * 
	 * @param record
	 * @return List<Map<String, Object>>
	 * @throws Exception
	 */
	List<WorkorderEntity> listWorkorder(WorkorderEntity entity) throws Exception;
	/**
	 * 
	 * @return List
	 * @throws Exception
	 */
	List<WorkorderEntity> listAllWorkorder() throws Exception;
	/**
	 * 
	 * @param we
	 * @return List
	 * @throws Exception
	 */
	List<WorkorderEntity> listChildWorkorder(WorkorderEntity we) throws Exception;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	WorkorderEntity checkParentWorkorder(Integer id) throws Exception;
	/**
	 * 
	 * @param topId
	 * @return
	 * @throws Exception
	 */
	WorkorderEntity listWorkorderById(Integer id) throws Exception; 
	
}
