package module4.service;

import module4.model.Product;

import java.util.List;

public interface IGenericService <D>{
    List<D> findAll();
    D save (D d );
    void delete(int id);
    D findId(int id);


}
