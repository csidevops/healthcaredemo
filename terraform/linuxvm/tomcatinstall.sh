#!/bin/bash
export DEBIAN_FRONTEND=noninteractive

# Install OpenJDK
apt-get update
echo "Y" | apt-get install default-jdk
echo JDK installed in the linux server 

# Create Tomcat User
useradd -r -m -U -d /opt/tomcat -s /bin/false tomcat
echo Tomcat user has been created 

# Install Tomcat (********Before running the script make sure you select the latest version of the tar file********)
rm -rf /tmp/apache*
wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.54/bin/apache-tomcat-9.0.54.tar.gz -P /tmp
tar xf /tmp/apache-tomcat-9.0.54.tar.gz -C /opt/tomcat
ln -s /opt/tomcat/apache-tomcat-9.0.54 /opt/tomcat/latest
chown -RH tomcat: /opt/tomcat/latest
sh -c 'chmod +x /opt/tomcat/latest/bin/*.sh'
echo Tomcat server has been installed 

# Clone a Git repository to access tomcat xml files 
rm -rf cnsidemoapp
git clone https://github.com/csidevops/healthcaredemo.git
echo git repoistory has been cloned 

# Copy tomcat service file to tomcat directory 
cp ./healthcaredemo/terraform/linuxvm/tomcat.service /etc/systemd/system/tomcat.service
echo Tomcat service file has been created 

# Start the tomcat service using the above tomcat.service file 
systemctl daemon-reload
systemctl enable tomcat
ufw allow 8080/tcp

# Copy tomcat user xml file to tomcat directory 
cp ./healthcaredemo/terraform/linuxvm/tomcat-users.xml /opt/tomcat/latest/conf/tomcat-users.xml
echo Tomcat user xml file has been created 

# Copy tomcat context xml file to tomcat manager directory 
cp ./healthcaredemo/terraform/linuxvm/context.xml /opt/tomcat/latest/webapps/manager/META-INF/context.xml
echo Tomcat context xml file has been created under manager directory

# Copy tomcat context xml file to tomcat host manager directory 
cp ./healthcaredemo/terraform/linuxvm/context.xml /opt/tomcat/latest/webapps/host-manager/META-INF/context.xml
echo Tomcat context xml file has been created under host manager directory

# Restart Tomcat server 
systemctl restart tomcat
echo Tomcat service has been started 

# Provide Folder permission for artifact deployment
chmod 777 /opt/tomcat/latest/webapps
echo Granted folder permissions in tomcat. Ready for deployment. Please proceed... 
