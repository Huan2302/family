package sample.Mapper;

import sample.Model.PersonModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<PersonModel>{
    @Override
    public PersonModel mapRow(ResultSet rs) {
        PersonModel personModel = new PersonModel();
        try {
            personModel.setId(rs.getInt("id"));
            personModel.setName(rs.getString("name"));
            personModel.setNameFather(rs.getString("nameFather"));
            personModel.setStatus(rs.getInt("status"));
            personModel.setNumberChild(rs.getInt("numberChild"));
            personModel.setBirth(rs.getString("birth"));
            personModel.setGeneration(rs.getInt("generation"));
            return personModel;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
