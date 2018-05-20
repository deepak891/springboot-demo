package com.devlabs.springbootdemo;

import org.springframework.data.repository.CrudRepository;

public interface PostDetailsRepository extends CrudRepository<PostDetails, Long> {
}
