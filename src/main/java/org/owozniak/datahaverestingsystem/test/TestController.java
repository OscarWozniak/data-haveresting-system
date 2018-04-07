package org.owozniak.datahaverestingsystem.test;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TestController {

  TestRepository repository;

  @GetMapping("test/create/{name}")
  public void create(@PathVariable String name){
    repository.save(new Test(name));
  }

  @GetMapping("test")
  public Iterable<Test> get(){
    return repository.findAll();
  }


}
