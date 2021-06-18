//package com.company.configuration;
//
//import com.datastax.driver.core.policies.ConstantReconnectionPolicy;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.cassandra.config.*;
////import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
//import org.springframework.data.cassandra.core.CassandraOperations;
//import org.springframework.data.cassandra.core.CassandraTemplate;
//import org.springframework.data.cassandra.core.convert.CassandraConverter;
//import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
//import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
//import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;
//import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
//import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
//import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
//import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;
//
//import java.util.List;
//import java.util.Set;
//
//import static java.util.Collections.singletonList;
//
//@Configuration
//@PropertySource(value = { "classpath:bootstrap.yml" })
//@ConfigurationProperties("spring.data.cassandra")
//@EnableReactiveCassandraRepositories(basePackages = "com.company")
//public class CassandraConfiguration extends AbstractCassandraConfiguration {
//
//    private static final String BASE_PACKAGES = "com.company";
////
////    @Value("${spring.data.cassandra.cluster-name}")
////    private String clusterName;
//
//    @Value("${spring.data.cassandra.keyspace-name}")
//    private String keySpaceName;
//
//    @Value("${spring.data.cassandra.contact-points}")
//    private String contactPoints;
//
//    @Value("${spring.data.cassandra.port}")
//    private int port;
//
//    @Bean
//    public CassandraOperations cassandraTemplate(CassandraSessionFactoryBean cassandraSession) {
//        return new CassandraTemplate(cassandraSession.getObject());
//    }
//
//    @Override
//    public CassandraSessionFactoryBean session() {
//        final CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
//        session.setCluster(cluster().getObject());
//        session.setKeyspaceName(keySpaceName);
//        session.setSchemaAction(SchemaAction.RECREATE_DROP_UNUSED);
//        session.setConverter(cassandraConverter());
//
//        return session;
//    }
//
//    @Override
//    public CassandraClusterFactoryBean cluster() {
//        final CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
////        cluster.setClusterName(clusterName);
//        cluster.setContactPoints(contactPoints);
//        cluster.setPort(port);
//        cluster.setKeyspaceCreations(getKeyspaceCreations());
//        cluster.setReconnectionPolicy(new ConstantReconnectionPolicy(1000));
//
//        return cluster;
//    }
//
//    @Override
//    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
//        final CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace(keySpaceName)
//                .ifNotExists().with(KeyspaceOption.DURABLE_WRITES, true).withSimpleReplication();
//
//        return singletonList(specification);
//    }
//
//    @Override
//    protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
//        return singletonList(DropKeyspaceSpecification.dropKeyspace(keySpaceName));
//    }
//
//    @Override
//    public CassandraConverter cassandraConverter() {
//        final CassandraMappingContext mappingContext = new CassandraMappingContext();
//        try {
//            mappingContext.setInitialEntitySet(entities());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return new MappingCassandraConverter(mappingContext);
//    }
//
//    @Override
//    public String[] getEntityBasePackages() {
//        return new String[]{BASE_PACKAGES};
//    }
//
//    @Override
//    protected String getKeyspaceName() {
//        return keySpaceName;
//    }
//
//    @Override
//    public SchemaAction getSchemaAction() {
//        return SchemaAction.CREATE_IF_NOT_EXISTS;
//    }
//
//    private Set<Class<?>> entities() throws ClassNotFoundException {
//        return CassandraEntityClassScanner.scan(singletonList(BASE_PACKAGES));
//    }
//}
