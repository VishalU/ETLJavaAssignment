package com.deere.custprodperspective.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deere.custprodperspective.domain.VwHrchyEntprExtrToMdl;
import com.deere.custprodperspective.form.AdminForm;
import com.deere.custprodperspective.form.ModelClassificationTypeForm;
import com.deere.custprodperspective.model.Brand;
import com.deere.custprodperspective.model.Structure;

public interface IfcCPSHomeService {

	public List<Brand> getBrandList();

	public HashMap<String, String> getQuickLinKMap();

	public List<Object[]> getHiecarchyRelationshipId(String categoryId);

	public void processAlertModel(AdminForm adminForm, String processInd);

	public List<ModelClassificationTypeForm> getModelClassificationTypeFormList();

	public Map<Integer,List<Structure>> getHrchyStructureMap();

	public List<VwHrchyEntprExtrToMdl> getHierarchyStructureList();

	public Map<Integer, String> getMarketSegmentMap();

	public Map<Integer, String> getMarketClassificationMap();
	
	 public Map<Integer, String> getCapRegionMap() ;

	public boolean isModelNotExistInCurrentCategorization(Integer valueOf,Integer parentIdOfModel);

	public Integer getModelParentId(String modelId);
	

}
