package com.ecommerce.ecom.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecommerce.ecom.models.Car;

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {

	// fetch car by brand then use param annotation
	List<Car> findByBrand(@Param("brand") String brand);

	// fetch car by color then use param annotation
	List<Car> findByColor(@Param("color") String color);
}
