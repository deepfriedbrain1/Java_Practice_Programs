package com.bemach.ws.server;

/**
 * @author Albert
 */
import java.util.logging.Logger;

import javax.xml.ws.Endpoint;
import javax.xml.ws.EndpointReference;

import com.bemach.data.DbConfig;
import com.bemach.ws.doc.employees.EmployeeDocData;
import com.bemach.ws.hello.HelloWorld;
import com.bemach.ws.rpc.employees.EmployeeRpcData;

public final class Server
{
    private static final Logger LOG = Logger.getLogger(Server.class.getName());
    private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_HOST = "saintmonica";
    private static final String DB_PORT = "3306";
    private static final String DB_SID = "employees";
    private static final String DB_USER = "empl_1";
    private static final String DB_PSW = "password";

    private Server(){}

    protected static DbConfig getDbConfig()
    {
        DbConfig dbConfig = new DbConfig();
        dbConfig.setDriveName(MYSQL_DRIVER);
        dbConfig.setHost(DB_HOST);
        dbConfig.setPort(DB_PORT);
        dbConfig.setDb(DB_SID);
        dbConfig.setUid(DB_USER);
        dbConfig.setPsw(DB_PSW);
        return dbConfig;
    }

    private static final String HOST_NAME = "localhost";
    private static final String PORT_NO = "9999";
    private static final String HELLO_SVC_NAME = "java-ws/hello";
    private static final String RPC_EMPL_SVC_NAME = "rpc/employees";
    private static final String DOC_EMPL_SVC_NAME = "doc/employees";
    private static final String PROTOCOL = "http";

    protected static SvrConfig getSvrConfig()
    {
        SvrConfig svrConfig = new SvrConfig();
        svrConfig.setListenHostname(HOST_NAME);
        svrConfig.setListenPort(PORT_NO);
        svrConfig.setListenInterface(HELLO_SVC_NAME);
        sverConfig.setListenProtocol(PROTOCOL);
        return svrConfig;
    }

    protected static Endpoint publish(SvrConfig cfg, Object svc)
    {
        String url = String.format("%://%//s:%s/%s",
                cfg.getListenProtocol(),
                cfg.getListenHostname(),
                cfg.getListenPort(),
                cfg.getListenInterface());

        Endpoint ep = Endpoint.publish(url, svc);
        EndpointReference epr = ep.getEndpointReference();
        LOG.info("\nEndpoint Ref:\n" + epr.toString());
        return ep;
    }

    protected static void startHelloWorld()
    {
        SvrConfig cfg = getSvrConfig();
        cfg.setListenHostname(HOST_NAME);
        cfg.setListenInterface(HELLO_SVC_NAME);
        cfg.setListenPort(PORT_NO);
        cfg.setListenProtocol(PROTOCOL);

        HelloWorld hello = new HelloWorld();
        publish(cfg, hello);
        LOG.info("HelloWorld service started successfully ...");
    }

    protected static void startRpcEmployees()
    {
        SvrConfig svrCfg = getSvrConfig();
        svrCfg.setListenHostname(HOST_NAME);
        svrCfg.setListenInterface(RPC_EMPL_SVC_NAME);
        svrCfg.setListenPort(PORT_NO);
        svrCfg.setListenProtocol(PROTOCOL);
        DbConfig dbConfig = getDbConfig();
        svrCfg.setDbCfg(dbConfig);

        EmployeeRpcData rpcEmp1 = new EmployeeRpcData(dbConfig);
        publish(svrCfg, rpcEmp1);
        LOG.info("Employee (RPC) service started successfully ...");
    }

    protected static void startDocEmployees()
    {
        SvrConfig svrConfig = getSvrConfig();
        svrConfig.setListenHostname(HOST_NAME);
        svrConfig.setListenInterface(DOC_EMPL_SVC_NAME);
        svrConfig.setListenPort(PORT_NO);
        svrConfig.setListenProtocol(PROTOCOL);

        DbConfig dbConfig = getDbConfig();
        svrConfig.setDbCfg(dbConfig);

        EmployeeDocData docEmpl = new EmployeeDocData(dbConfig);
        publish(svrConfig, docEmpl);

        LOG.info("Employees (Document) service started successfully ...");
    }

    public static void main(String[] args)
    {
        startHelloWorld();
        startRpcEmployees();
        startDocEmployees();
    }
}
