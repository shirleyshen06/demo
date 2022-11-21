package com.example.demo.config;

import com.datastax.oss.driver.internal.core.auth.PlainTextAuthProvider;
import com.datastax.oss.driver.internal.core.connection.ConstantReconnectionPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
//import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
//import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;

import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
//import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableReactiveCassandraRepositories(basePackages = "com.example.demo")
public class CategoryConfig extends AbstractReactiveCassandraConfiguration {


    @Value("${spring.data.cassandra.keyspace-name}")
    private String keySpace;
    @Value("${spring.data.cassandra.contact-points}")
    private String contactPoints;
    @Value("${spring.data.cassandra.port}")
    private int port;


    @Value("${spring.data.cassandra.username}")
    private String username;

    @Value("${spring.data.cassandra.password}")
    private String password;


    @Value("${spring.data.cassandra.schema-action}")
    private SchemaAction schemaAction;

    @Override
    protected String getContactPoints() {
        return contactPoints;
    }


    @Override
    protected int getPort() {
        return port;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return schemaAction;
    }


    @Override
    protected String getKeyspaceName() {
        return keySpace;
    }


//    @Override
//    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
//
//        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.
//                .ifNotExists()
//                .with(KeyspaceOption.DURABLE_WRITES, true);
//        //.withNetworkReplication(DataCenterReplication.dcr("foo", 1), DataCenterReplication.dcr("bar", 2));
//
//        return Arrays.asList(specification);
//    }

    @Override
    protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
        return Arrays.asList(DropKeyspaceSpecification.dropKeyspace(keySpace));
    }

////
//    @Override
//    public CassandraClusterFactoryBean cluster() {
//        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
//        // cluster.setClusterName(clusterName);
//        PlainTextAuthProvider sap = new PlainTextAuthProvider(username, password);
//        cluster.setContactPoints(contactPoints);
//        cluster.setPort(port);
//        cluster.setAuthProvider(sap);
//        cluster.setJmxReportingEnabled(false);
//        cluster.setKeyspaceCreations(getKeyspaceCreations());
//        cluster.setReconnectionPolicy(new ConstantReconnectionPolicy(1000));
//
//        return cluster;
//    }

//    @Override
//    public CqlSessionFactoryBean cassandraSession() {
//        CqlSessionFactoryBean cqlSessionFactoryBean = super.cassandraSession();
//        cqlSessionFactoryBean.setContactPoints(contactPoints);
//        cqlSessionFactoryBean.setPort(port);
//        cqlSessionFactoryBean.setUsername(username);
//        cqlSessionFactoryBean.setPassword(password);
//        return cqlSessionFactoryBean;
//    }

}
