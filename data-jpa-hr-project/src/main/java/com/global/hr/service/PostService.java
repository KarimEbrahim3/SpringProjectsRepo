package com.global.hr.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.global.hr.entity.PostDto;

@Service
public class PostService {

	private static String POST_URL = "https://jsonplaceholder.org/posts";
	
	public PostDto getPostById(Long id) {
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<PostDto> re = rt.getForEntity(POST_URL +"/"+id, PostDto.class);
		return re.getBody();
	}
	
	public PostDto addPost(PostDto dto) {
		RestTemplate rt = new RestTemplate();
		HttpEntity<PostDto> request = new HttpEntity<>(dto);
		ResponseEntity<PostDto> re = rt.postForEntity(POST_URL ,request, PostDto.class);
		return re.getBody();
	}
	
	public void updatePost(PostDto dto) {
		RestTemplate rt = new RestTemplate();
		HttpEntity<PostDto> request = new HttpEntity<>(dto);
		rt.put(POST_URL ,request);
	}
	
	public void deletePostById(Long id) {
		RestTemplate rt = new RestTemplate();
		
		rt.delete(POST_URL +"/"+id);
		
	}
}
