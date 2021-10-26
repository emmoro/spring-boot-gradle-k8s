## Spring boot with kubernetes(k8s)

Project in Spring Boot using database MySQL, gradle and Kubernetes.

## Tools used in project
* Java 11
* Gradle
* Kubernetes
* IDE was used Intellij.
* Postman
</br>

## Getting Started
Necessary install kubernetes and Docker to use this project.

## How to use the system

* After to install docker and Kubernetes, compile the project
* Create the image the 'app-k8s' - command: 'docker build -t emmoro/app-k8s:v1 .'
* After this necessary entre in project in the folder 'k8s'
* Execute these commands:
<br><br>
  - kubectl apply -f mysql-configmap.yml
  - kubectl apply -f mysqldb-root-credentials.yml
  - kubectl apply -f mysqldb-credentials.yml
  - kubectl apply -f mysql-deployment.yml
  - kubectl apply -f deployment.yml
<br><br>    

* After this you can look the 'deployment, service, pod...' active, using the command: 'kubectl get all'
* If you take the port, you can see this project web '(service/app    NodePort    10.108.195.55   <none> 8080:*30163*/TCP 43m)'
* With this you can access the system in : 'http://localhost:30163/api/consoles/'
* To use all call this project, you can use the collection, the collection is in the folder : 'spring-boot-gradle-k8s\Collection'
* Import this json to 'Postman' to make call.

## Note
* How install docker: https://docs.docker.com/desktop/#download-and-install
* How install kubernetes: https://kubernetes.io/docs/tasks/tools/