#!/bin/bash
#Copier tous les contenus du dossier magasin/web vers /opt/tomcat/webapps/magasin (serveur tomcat)
sudo cp -r web/* /opt/tomcat/webapps/magasin

#Trouver tous les fichiers .jar sauf le servlet-api.jar puis les copier vers /opt/tomcat/lib/
find lib/ -type f -name '*.jar' ! -name 'servlet-api.jar' -exec cp {} /opt/tomcat/lib/ \;

#Copier tous les contenu du dossier magasin/lib vers /opt/tomcat/webapps/magasin/WEB-INF/lib/
sudo cp -r lib/* /opt/tomcat/webapps/magasin/WEB-INF/lib/

#Modifier la permission du dossier /opt/tomcat/webapps/magasin en rwx pour tous
sudo chmod  -R 777 /opt/tomcat/webapps/magasin/

#Compiler tous les fichier .java dans magasin/src/  vers /opt/tomcat/webapps/magasin/WEB-INF/classes
javac -cp "lib/*" -d /opt/tomcat/webapps/magasin/WEB-INF/classes src/*/*.java

#message
echo "Succes: Deployement reussie."
