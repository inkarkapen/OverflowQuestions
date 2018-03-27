package com.inkarkapen.overflow.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.inkarkapen.overflow.models.Tag;
import com.inkarkapen.overflow.repositories.TagRepository;

@Service
public class TagService {
	private static TagRepository tagRepository;
    public TagService(TagRepository tagRepository) {
    	this.tagRepository = tagRepository;
    }
    
    public static List<Tag> allTags() {
        return tagRepository.findAll();
    }

	public static void addTag(@Valid Tag tag) {
		tagRepository.save(tag);
	}

	public static Tag findById(Long id) {
		return tagRepository.findById(id).orElse(null);
	}
	
	public static Tag findBySubject(String tag) {
		return tagRepository.findByTag(tag);
	}
}
