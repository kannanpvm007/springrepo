package com.kgisl.springxml.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.kgisl.springxml.model.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ContactDAOImpl implements ContactDAO {
    // private JdbcTemplate jdbcTemplate;

    // public ContactDAOImpl(DataSource dataSource) {
    // jdbcTemplate = new JdbcTemplate(dataSource);
    // }

    @Autowired
    DataSource datasource;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void saveOrUpdate(Contact contact) {
        if (contact.getId() > 0) {
            // update
            String sql = "UPDATE contact SET name=?, email=?, address=?, " + "telephone=? WHERE contact_id=?";
            jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(),
                    contact.getTelephone(), contact.getId());
        } else {
            // insert
            String sql = "INSERT INTO contact (name, email, address, telephone)" + " VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(),
                    contact.getTelephone());
        }

    }

    public void delete(int contactId) {

    }

    public Contact get(int contactId) {
        return null;
    }

    public List<Contact> list() {
        String sql = "SELECT * FROM contact";
        List<Contact> listContact = jdbcTemplate.query(sql, new RowMapper<Contact>() {

            // @Override
            public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
                Contact aContact = new Contact();

                aContact.setId(rs.getInt("contact_id"));
                aContact.setName(rs.getString("name"));
                aContact.setEmail(rs.getString("email"));
                aContact.setAddress(rs.getString("address"));
                aContact.setTelephone(rs.getString("telephone"));

                return aContact;
            }

        });

        return listContact;
    }

}
