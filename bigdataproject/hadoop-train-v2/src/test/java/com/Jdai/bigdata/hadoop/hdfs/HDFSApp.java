package com.Jdai.bigdata.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;

public class HDFSApp {
    public static final String HDFS_PATH = "hdfs://hadoop000:8020";
    FileSystem fileSystem = null;
    Configuration configuration = null;
    @Before
    public void setUp() throws Exception{
        configuration = new Configuration();
        configuration.set("dfs.replication","1");
        fileSystem = FileSystem.get(new URI(HDFS_PATH),configuration,"hadoop");
        System.out.println("--------------setup-----------------");
    }
    @Test
    public void mkdir() throws Exception{
        fileSystem.mkdirs(new Path("/hdfsapi/test"));
    }
    @Test
    public void create() throws Exception{
        FSDataOutputStream out = fileSystem.create(new Path("/hdfsapi/test/b.txt"));
        out.writeUTF("hello Jiale Dai");
        out.flush();
        out.close();
    }
    @Test
    public void text() throws  Exception{
        FSDataInputStream in = fileSystem.open(new Path("/hdfsapi/test/hdfs-site.xml"));
        IOUtils.copyBytes(in,System.out,1024);
    }
    @Test
    public void rename() throws Exception{
        Path oldPath = new Path("/hdfsapi/test/b.txt");
        Path newPath = new Path("/hdfsapi/test/c.txt");
        boolean result = fileSystem.rename(oldPath,newPath);
        System.out.println(result);
    }
    @Test
    public void copyFromLocalFile()throws Exception{
        Path src = new Path("/home/hadoop/app/hadoop-2.6.0-cdh5.15.1/etc/hadoop/core-site.xml");
        Path dst = new Path("/hdfsapi/test/");
        fileSystem.copyFromLocalFile(src,dst);
    }
    @Test
    public void copyFromLocalBigFile()throws Exception{
        InputStream in =  new BufferedInputStream(new FileInputStream(new File("/home/hadoop/software/jdk-8u91-linux-x64.tar.gz")));
        FSDataOutputStream out = fileSystem.create(new Path("/hdfsapi/test/jdk"), new Progressable() {
            @Override
            public void progress() {
                System.out.print("#");
            }
        });
        IOUtils.copyBytes(in,out,4096);
    }
    @Test
    public void copyToLocalFile()throws Exception{
        Path src = new Path("/hdfsapi/test/a.txt");
        Path dst = new Path("/home/hadoop");
        fileSystem.copyToLocalFile(src,dst);
    }
    @Test
    public void listFiles()throws Exception{
        FileStatus[] status = fileSystem.listStatus(new Path("/hdfsapi/test"));
        for (FileStatus fileStatus : status) {
            System.out.println(fileStatus);
        }
    }
    @After
    public void tearDown(){
        fileSystem = null;
        configuration = null;
        System.out.println("--------------teardowm---------------");
    }
}
