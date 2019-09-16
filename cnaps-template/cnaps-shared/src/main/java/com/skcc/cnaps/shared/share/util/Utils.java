package com.skcc.cnaps.shared.share.util;

import java.beans.FeatureDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Utils {
	public static String[] getNullPropertyNames(Object source) {
		final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
		return Stream.of(wrappedSource.getPropertyDescriptors()).map(FeatureDescriptor::getName)
				.filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null).toArray(String[]::new);
	}
	
	public static <T> T fromJsonStr(String jsonStr, Class<T> clazz) {
		if (jsonStr == null || jsonStr.isEmpty()) {
			return null;
		}

		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(mapper.getVisibilityChecker().withFieldVisibility(Visibility.ANY));
		
		try {
			return mapper.readValue(jsonStr, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String toJsonStr(Object obj) {
		if (obj == null)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(mapper.getVisibilityChecker().withFieldVisibility(Visibility.ANY));
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<String> splitCamelCaseString(String s) {
		List<String> result = new ArrayList<>();
		for (String w : s.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
			result.add(w);
		}
		return result;
	}

	public static String camelToUnderline(String camel) {
		List<String> camelClassnames = Utils.splitCamelCaseString(camel);

		String underline = "";
		for (String name : camelClassnames) {
			if (!underline.isEmpty()) {
				underline = underline + "_";
			}
			underline = underline + name;
		}
		return underline;
	}
}

