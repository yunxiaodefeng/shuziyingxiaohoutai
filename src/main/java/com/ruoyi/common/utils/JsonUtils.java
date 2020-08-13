package com.ruoyi.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Map;
//import cn.czhh.domaim.api.PaperQuesInfo;
//import cn.czhh.domaim.api.QuesReadyInfo;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.core.type.TypeReference;

public class JsonUtils {
	private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
	private static ObjectMapper mapper = new ObjectMapper();
	// 定义jackson对象
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private final static ObjectMapper objectMapper = new ObjectMapper();
	public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
		JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
		try {
			List<T> list = MAPPER.readValue(jsonData, javaType);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * 
	 * @param obj
	 * @return
	 * @throws IOException
	 */
	public static String object2Json(Object obj) throws IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setSerializationInclusion(Include.NON_NULL);  
		return mapper.setSerializationInclusion(Include.NON_NULL).writeValueAsString(obj);
	}

	public static String object2Json(Object obj, String dateFormat) throws IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setSerializationInclusion(Include.NON_NULL); 
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
//		mapper.setDateFormat(format);

		return mapper.setSerializationInclusion(Include.NON_NULL).setDateFormat(format).writeValueAsString(obj);
	}

	/**
	 * ���ַ���ת��ʵ���࣬����б�ܵ��ַ���
	 */
	public static <T> T jsonToEntity(String json, Class<T> clazz) throws IOException {
//		ObjectMapper mapper = new ObjectMapper();
		// ����б�˵��ַ�
//		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		return mapper.readValue(json, clazz);
	}

	public static <T> List<T> json2List(String jsonArrayStr,Class<T> clazz)throws Exception{  
    	  ObjectMapper mapper = new ObjectMapper();
		  JavaType javaType=mapper.getTypeFactory().constructParametricType(List.class, clazz);
		  return  mapper.readValue(jsonArrayStr,javaType);      
	}
	public static <T> String mapToJson(Map<String, T> map) {
		 Gson gson = new Gson();
		 String jsonStr = gson.toJson(map);
		 return jsonStr;
		}   
	
	  public static Map<Object, Object> jsonToMap(Object jsonObj) {
	        JSONObject jsonObject = JSONObject.fromObject(jsonObj);
	        Map<Object, Object> map = (Map)jsonObject;
	        return map;
	    }
	  
	    public static <T> T json2pojo(String jsonStr, Class<T> clazz)
	            throws Exception {
	        return objectMapper.readValue(jsonStr, clazz);
	    }
	
	  
//	/**
//	 * ���ַ���ת��JsonNode������б�ܵ��ַ���
//	 */
//	public static JsonNode jsonToJsonNode(String json) throws IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		// ����б�˵��ַ�
//		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
//		// ��������
//		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
//		return mapper.readValue(json, JsonNode.class);
//	}

//	public static <T> String objectToJson(Object object, Class<T> cls) throws Exception {
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setSerializationInclusion(Include.NON_NULL); 
//		mapper.registerSubtypes(cls);
//		String reqJson = mapper.writeValueAsString(object);
//		return reqJson;
//	}
//	
//	public static <T> String objectToJson(Object object,String dateFormat , Class<T> cls) throws Exception {
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setSerializationInclusion(Include.NON_NULL); 
//		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
//		mapper.setDateFormat(format);
//		mapper.registerSubtypes(cls);
//		String reqJson = mapper.writeValueAsString(object);
//		return reqJson;
//	}
	
//	public static <T> List<T> jsonToList(String jsonArrayStr,Class<T> clazz)throws Exception{  
//		  ObjectMapper mapper = new ObjectMapper();	
//	      List<Map<String,Object>> list = mapper.readValue(jsonArrayStr, new TypeReference<List<T>>() {});  
//	      List<T> result = new ArrayList<>();  
//	      for (Map<String, Object> map : list) {  
//	          result.add(map2pojo(map, clazz));  
//	      }  
//	      return result;  
//	  }
//	
//	/** 
//     * map convert to javaBean 
//     */  
//    public static <T> T map2pojo(Map map,Class<T> clazz){  
//    	ObjectMapper mapper = new ObjectMapper();	
//        return mapper.convertValue(map, clazz);  
//    }  
//    
    
  
	
//	public static JavaType getCollectionType(ObjectMapper mapper,Class<?> collectionClass, Class<?>... elementClasses) {   
//	     return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
//	 }
	
/*	 public static  JavaType toJavaBeanList(String content, TypeReference<List>  typeReference) throws IOException {
		 ObjectMapper mapper = new ObjectMapper();	   
		 
		return mapper.getTypeFactory().constructParametricType(PaperQuesInfo.class, PaperQuesInfo.class);   
//		 ObjectMapper mapper = new ObjectMapper();		 
//	     return mapper.readValue(content, typeReference);		       
		 }*/
/*
	 public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {   
		 ObjectMapper mapper = new ObjectMapper();	   
		 return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
	    }*/
	
	
//	public static void main(String[] args) throws Exception {
		
//		ObjectMapper mapper = new ObjectMapper();
//		long s=System.currentTimeMillis();
//		for(int i=0;i<10;i++){
//			String str = "[{\"questId\":\"38\",\"questText\":\"����������\\\\��ʱ���һ�������غ������\",\"questMod\":\"1\",\"showMod\":\"0\",\"listReadyInfo\":[{\"reaId\":\"A\",\"reaText\":\"�ǳ�����\",\"reaImage\":\"\",\"reaShowMod\":\"0\",\"reaScore\":5},{\"reaId\":\"B\",\"reaText\":\"�ȽϷ���\",\"reaImage\":\"\",\"reaShowMod\":\"0\",\"reaScore\":4},{\"reaId\":\"C\",\"reaText\":\"��ȷ��\",\"reaImage\":\"\",\"reaShowMod\":\"0\",\"reaScore\":3},{\"reaId\":\"D\",\"reaText\":\"�Ƚϲ�����\",\"reaImage\":\"\",\"reaShowMod\":\"0\",\"reaScore\":2},{\"reaId\":\"E\",\"reaText\":\"�ǳ�������\",\"reaImage\":\"\",\"reaShowMod\":\"0\",\"reaScore\":1}]}]";
//			JavaType javaType=mapper.getTypeFactory().constructParametricType(List.class, PaperQuesInfo.class);
//			     
//			List<PaperQuesInfo> list = mapper.readValue(str,javaType);
//			System.out.println(JsonUtils.object2Json(list));
////			System.out.println(JsonUtils.objectToJson(list,List.class));
//		}
//		System.out.println(System.currentTimeMillis()-s);
//		
//		String str2 = "{\"questId\":\"38\",\"questText\":\"������������ʱ���һ�������غ������\",\"questMod\":\"1\",\"showMod\":\"0\",\"listReadyInfo\":[{\"reaId\":\"A\",\"reaText\":\"�ǳ�����\",\"reaImage\":\"\",\"reaShowMod\":\"0\",\"reaScore\":5},{\"reaId\":\"B\",\"reaText\":\"�ȽϷ���\",\"reaImage\":\"\",\"reaShowMod\":\"0\",\"reaScore\":4},{\"reaId\":\"C\",\"reaText\":\"��ȷ��\",\"reaImage\":\"\",\"reaShowMod\":\"0\",\"reaScore\":3},{\"reaId\":\"D\",\"reaText\":\"�Ƚϲ�����\",\"reaImage\":\"\",\"reaShowMod\":\"0\",\"reaScore\":2},{\"reaId\":\"E\",\"reaText\":\"�ǳ�������\",\"reaImage\":\"\",\"reaShowMod\":\"0\",\"reaScore\":1}]}";
//
//		 String str3="{\"reaId\":\"E\",\"reaText\":\"�ǳ�������\",\"reaImage\":\"\",\"reaShowMod\":\"0\",\"reaScore\":1}";
//		 QuesReadyInfo ques= mapper.readValue(str3, QuesReadyInfo.class);
//		 System.out.println(mapper.readValue(str3, QuesReadyInfo.class));
//		 System.out.println(JsonUtils.objectToJson(ques,QuesReadyInfo.class));
//		 System.out.println(JsonUtils.object2Json(ques));
//		 
//		 
//		     ObjectMapper mapper1 = new ObjectMapper();  
//	        //JSON ----> JsonNode  
//	        JsonNode rootNode = JsonUtils.jsonToJsonNode(str2);    
//	        Iterator<String> keys = rootNode.fieldNames();     
//	        while(keys.hasNext()){    
//	            String fieldName = keys.next();    
//	            System.out.println(fieldName + ": " + rootNode.path(fieldName).toString());    
//	        }  
//	        //JsonNode ----> JSON  
//	        System.out.println(mapper.writeValueAsString(rootNode));  
//	}

}
