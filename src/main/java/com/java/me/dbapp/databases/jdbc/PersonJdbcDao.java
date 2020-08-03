package com.java.me.dbapp.databases.jdbc;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao
{
    @Autowired
    JdbcTemplate jdbcTemplate;


    class PersonRowMapper implements RowMapper<Person>
    {
        @Override
        public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Person person=new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setLocation(resultSet.getString("location"));
            person.setBirthDate(resultSet.getTimestamp("birth_date"));
            return person;
        }
    }
    //to find all
    public List<Person> findAll()
    {
//    return jdbcTemplate.query("select * from person",
//            new BeanPropertyRowMapper<Person>(Person.class));
        return jdbcTemplate.query("select * from person",
                new PersonRowMapper());
    }
    //to get data By Id
    public Person findById(int id)
    {
        return jdbcTemplate.queryForObject("select * from person where id=?",
                new Object[]{id},new BeanPropertyRowMapper<Person>(Person.class));
    }
    // dalete the data By Id
    public int daleteById(int id)
    {
        return jdbcTemplate.update("delete from person where id=?",
                new Object[]{id});
    }
    // Insert data into H2 database
    public int insertData(Person person)
    {
        return jdbcTemplate.update("insert into person(id, name, location, birth_date)"
                        +"values(?,?,?,?)",
                          new Object[]{person.getId(),person.getName(),
                                  person.getLocation(),
                                  new Timestamp(person.getBirthDate().getTime())});
    }
    // Update data into H2 database
    public int updateData(Person person)
    {
        return jdbcTemplate.update("update person "+
                "set name=?, location=?, birth_date=? where id=?",
                new Object[]{person.getName(), person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime()),person.getId()});
    }
}
