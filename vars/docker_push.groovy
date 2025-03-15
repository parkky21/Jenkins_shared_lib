def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'dockerhub-key', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
      sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
