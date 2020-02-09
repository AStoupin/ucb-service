//https://medium.com/@shrut_terminator/devops-usecase-jira-jenkins-integration-4051413446a9
node('docker') {
 
    stage 'Checkout'
        checkout scm
        
    stage 'Build'
		withMaven(
		        // Maven installation declared in the Jenkins "Global Tool Configuration"
		        maven: 'maven',
		        jdk: 'JDK8'
		        //,
		        // Maven settings.xml file defined with the Jenkins Config File Provider Plugin
		        // We recommend to define Maven settings.xml globally at the folder level using 
		        // navigating to the folder configuration in the section "Pipeline Maven Configuration / Override global Maven configuration"
		        // or globally to the entire master navigating to  "Manage Jenkins / Global Tools Configuration"
		        //mavenSettingsConfig: 'my-maven-settings'
		        ) {
		
		      // Run the maven build
		      sh "mvn -s /var/jenkins_home/maven/settings.xml clean package "
		    }
	       sh "docker build -t ucb-service -t ucb-service:${BUILD_NUMBER} -f Dockerfile ."
	stage("Check") 
    // Run build
    	input message: "Approve build?" 
             
    stage 'Run'
    	
	       sh "docker rm -f  ucb-service  &>/dev/null && echo 'Removed old ucb-service container'"
	       sh "docker run -d -p 8099:8090 --name ucb-service ucb-service "
    

}