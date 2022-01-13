package sample.Dao.impl;

import sample.Mapper.PersonMapper;
import sample.Model.PersonModel;

import java.util.List;

public class PersonDao extends AbstractDao<PersonModel> {
    public void insertPerson(PersonModel personModel){
        String sql = "insert into family(name,nameFather,birth,status,numberChild,generation) values (?,?,?,?,?,?);";
        insert(sql,personModel.getName(),personModel.getNameFather(),
                personModel.getBirth(),personModel.getStatus(),personModel.getNumberChild(),
                personModel.getGeneration());
    }

    public List<PersonModel> findAll(){
        String sql = "select * from family";
        return query(sql, new PersonMapper());
    }
    public List<PersonModel> getName(String name){
        String sql = "select * from family where nameFather = ?";
        return query(sql,new PersonMapper(),name);
    }
    public List<PersonModel> getGen(int gen){
        String sql = "select * from family where generation = ?";
        return query(sql,new PersonMapper(),gen);
    }

    public PersonModel findById(String name){
        String sql = "SELECT * FROM family WHERE name = ?";
        List<PersonModel> personModels = query(sql, new PersonMapper(), name);
        return personModels.isEmpty() ? null : personModels.get(0);
    }
}
