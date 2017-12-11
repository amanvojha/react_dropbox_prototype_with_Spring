import axios from "axios"
import setAuthorizationToken from '../utils/setAuthorizationToken';
import jwt from 'jsonwebtoken';
var fileDownload = require('react-file-download');

export function setFirstName(first_name) {
  
  return {
    type: "FNAME",
    payload: first_name
  }
}

export function setLastName(last_name) {
  
  return {
    type: "LNAME",
    payload: last_name
  }
}

export function setUsername(username) {
  console.log('SETTING USER' + username)
  return {
    type: "USER",
    payload: username
  }
}

export function setHome(username,isValid) {
  console.log('SETTING HOME' + username + isValid)
  return {
    type: "HOME",
    payload: {username,isValid}
  }
}



export function setPassword(password) {
  
  return {
    type: "PASS",
    payload: password
  }
}

export function setShareId(fileId) {
  
  return {
    type: "SET_SHARE_FILE_ID",
    payload: fileId
  }
}

export function setFolder(parentId) {
  
  /*return {
    type: "SET_FOLDER",
    payload: fileId
  }*/
  console.log('SET FOLDER ' + parentId)

   return function(dispatch){

          axios({
              method:'post',
              url:'http://localhost:8082/api/setFiles',
              withCredentials: true,
              headers: {'Accept': 'application/json','Content-Type': 'application/json'},
              data: parentId
              
           })
         .then((response) => {

              console.log(response);
              dispatch({
                   type: "SET_FOLDER",
                   payload: response.data,parentId
              }) 

          }).catch((err) => {

             })

  }
}

export function login(username,password) {
    
  var payload = {
      username: username,
      password: password
  };


  console.log('LOGIN')
  return function(dispatch){
        fetch(`http://localhost:3002/api/login`, {
          method: 'POST',
          headers: {
          'Accept': 'application/json, text/plain, */*',
          'Content-Type': 'application/json'
        },
        credentials:'include',
        body: JSON.stringify( payload )
        })
        .then(response => {
          
          console.log('RESPONSE ' + response.status)
          if(response.status==200){
            dispatch({
                   type: "LOGIN",
                  payload: true
              })
            }
            else {
              dispatch({
                   type: "LOGIN",
                  payload: false
              })
            } 
      })
        .catch(error => {
            console.log("This is error");
            return error;
        });
      
  }

}

export function checkAuth() {
  
    
  console.log('CHECK SERVER')
  return function(dispatch){
        fetch(`http://localhost:3002/api/checkAuth`, {
          method: 'POST',
          headers: {
          'Accept': 'application/json, text/plain, */*',
          'Content-Type': 'application/json'
        },
        credentials:'include',
          
        })
        .then(res => res.json())
        .then(data => 

          
          dispatch({
                   type: "AUTH",
                   payload: data
            })

        )
        .catch(error => {
            console.log("This is error");
            return error;
        });



      
  }
}

export function logout() {
  
    
  console.log('LOGOUT')
  return function(dispatch){
        fetch(`http://localhost:3002/api/logout`, {
          method: 'POST',
          headers: {
          'Accept': 'application/json, text/plain, */*',
          'Content-Type': 'application/json'
        },
        credentials:'include',
          
        })
        .then(response => {
          
          console.log('RESPONSE ' + response)
          dispatch({
            type: "LOGOUT",
            payload: false
        })
            
      })
        .catch(error => {
            console.log("This is error");
            return error;
        });
   
  }
}

//SPRING
export function signup(first_name, last_name, username, password) {
  
  
  return function(dispatch){
      axios.post('http://localhost:8082/api/signup', {
            
                  first_name,last_name,username,password
            
            })
            .then(function (response) {
                                
               dispatch({
                   type: "SIGNUP",
                   payload: response.data
              })
             
            })
            .catch(function (error) {
              console.log(error);
              });
  }
}

//Upload files from Home 
export function upload(username,file,isFile,parentId) {

  console.log('UPLOAD HOME USERNAME' + username);
  const file_data = new FormData();
  file_data.append('username' , username);
  file_data.append('isFile', isFile);
  file_data.append('parentId', parentId);
  file_data.append('file' , file);

  const headers = {
    'Accept': 'application/json'
  };


    return function(dispatch){


        axios({
              method:'post',
              url:'http://localhost:3002/api/upload',
              withCredentials: true,
              headers: {'Accept': 'application/json','Content-Type': 'application/json'},
              data: file_data
           })
         .then((response) => {

              console.log('TEST', response.data);
              dispatch({
                   type: "UPLOAD",
                   payload: response.data.files
              })

          }).catch((err) => {

             })

  

      
  }
}

//Upload folder 
//SPRING
export function uploadFolder(file_name,isFile,parentId,username) {

  console.log('UPLOAD FOLDER '+ file_name);


    return function(dispatch){


        axios({
              method:'post',
              url:'http://localhost:8082/api/uploadFolder',
              withCredentials: true,
              headers: {'Accept': 'application/json','Content-Type': 'application/json'},
              data: {file_name,isFile,parentId,username}
           })
         .then((response) => {

              console.log('TEST', response.data);
              dispatch({
                   type: "UPLOAD",
                   payload: response.data
              })

          }).catch((err) => {

             })

  

      
  }
}

//Upload folder
//SPRING 
export function createGroup(username,groupName,isFile,parentId) {

  console.log('CREATE GROUP '+ groupName);


    return function(dispatch){


        axios({
              method:'post',
              url:'http://localhost:8082/api/createGroup',
              withCredentials: true,
              headers: {'Accept': 'application/json','Content-Type': 'application/json'},
              data: {username,groupName,isFile,parentId}
           })
         .then((response) => {

              console.log('TEST', response.data);
              dispatch({
                   type: "GROUP",
                   payload: response.data
              })

          }).catch((err) => {

             })

  

      
  }
}

//Set All Files
//SPRING
export function setFiles(parentId) {

  console.log('AMAN SET FILES ' + parentId);

  return function(dispatch){

          axios({
              method:'post',
              url:'http://localhost:8082/api/setFiles',
              withCredentials: true,
              headers: {'Accept': 'application/json','Content-Type': 'application/json'},
              data: parentId
              
           })
         .then((response) => {
              console.log('AMANNNNNNNNN')
              console.log(response);
              dispatch({
                   type: "SET_FILES",
                   payload: response.data
              }) 

          }).catch((err) => {

             })

  }


}
//Set Recent Files
export function setHomeFiles(username) {

  console.log('SET HOME FILES ' + username);

  return function(dispatch){

    axios.post('http://localhost:3002/api/setHomeFiles', {username} )
         .then((response) => {

              console.log(response);
              dispatch({
                   type: "SET_HOME_FILES",
                   payload: response.data.list
              }) 

          }).catch((err) => {

             })

  }

}

export function setStar(file_id,file_name) {

  console.log('SET STAR USERNAME ');
  console.log('FILE ID' + file_id);


  return function(dispatch){

          axios({
              method:'post',
              url:'http://localhost:3002/api/star',
              withCredentials: true,
              headers: {'Accept': 'application/json','Content-Type': 'application/json'},
              data:{file_id,file_name}
              
           })
          .then((response) => {

              
              if(response.data.files==undefined){
                  console.log('NO STARRED FILES')
              }
              else {
                dispatch({
                     type: "STAR_FILES",
                     payload: response.data.files
                })
              }   

          }).catch((err) => {

             })

  }

}

//Unset Starred files after clicking red star icon
export function unsetStar(file_id,file_name) {

  console.log('UNSET USERNAME ');
  console.log('FILE ID' + file_id + file_name);

  return function(dispatch){

          axios({
              method:'post',
              url:'http://localhost:3002/api/unstar',
              withCredentials: true,
              headers: {'Accept': 'application/json','Content-Type': 'application/json'},
              data:{file_id,file_name}
              
           })
          .then((response) => {

              
              if(response.data.files==undefined){
                  console.log('NO STARRED FILES')
              }
              else {
                dispatch({
                     type: "STAR_FILES",
                     payload: response.data.files
                })
              }   

          }).catch((err) => {

             })

  }
}


//Getting list of Starred files after refresh
export function getStar() {

  console.log('STAR FILES ');

  return function(dispatch){

          axios({
              method:'post',
              url:'http://localhost:3002/api/getStar',
              withCredentials: true,
              headers: {'Accept': 'application/json','Content-Type': 'application/json'},
              
           })
         .then((response) => {

              
              if(response.data.files==undefined){
                  console.log('NO STARRED FILES')
              }
              else {
                dispatch({
                     type: "SET_STAR_FILES",
                     payload: response.data.files
                })
              }   

          }).catch((err) => {

          })

  }


}

//SPRING
export function getGroup(username) {

  console.log('GET GROUP ' + username);

  return function(dispatch){

          axios({
              method:'post',
              url:'http://localhost:8082/api/getGroup',
              withCredentials: true,
              headers: {'Accept': 'application/json','Content-Type': 'application/json'},
              data: username
           })
         .then((response) => {

              
              if(response.data==undefined){
                  console.log('NO GROUPS')
              }
              else {
                dispatch({
                     type: "GROUP",
                     payload: response.data
                })
              }   

          }).catch((err) => {

          })

  }


}

export function download(username,file_name) {

    console.log('DOWNLOAD ' + username + file_name);
    return function(dispatch){

      axios({
              method:'get',
              url:'http://localhost:3002/api/download',
              responseType:'blob',
              params:{
                        file_name
                      }
           })
           .then((response) => {

              console.log(response);
              
              fileDownload(response.data, file_name);

              dispatch({
                   type: "TEST",
                   payload: response.data.star_list
              }) 

          }).catch((err) => {

             })

  }


}

//Delete files
export function deleteFile(username,file_id,file_name) {

  console.log('DELETE FILE USERNAME ' + username);
  console.log('FILE ID' + file_id);

  return function(dispatch){

         axios({
              method:'post',
              url:'http://localhost:3002/api/deleteFile',
              withCredentials: true,
              headers: {'Accept': 'application/json','Content-Type': 'application/json'},
              data: {file_id,file_name}
           })
         .then((response) => {

              
              dispatch({
                   type: "DELETE_FILES",
                   payload: response.data.files
              })  

          }).catch((err) => {

          })



  }
}

//Get User Activity
//SPRING
export function getActivity(username) {

  console.log('ACTIVITY USERNAME ' + username);
  

  return function(dispatch){

    axios({
              method:'post',
              url:'http://localhost:8082/api/getActivity',
              withCredentials: true,
              headers: {'Accept': 'application/json','Content-Type': 'application/json'},
              data:username
              
           })
         .then((response) => {

              
              dispatch({
                   type: "ACTIVITY",
                   payload: response.data
              })  

          }).catch((err) => {

          })

  }
}

//Set Profile Details
export function setProfile(username, bio, work, education, mobile, interest) {

  console.log('PROFILE USERNAME ' + username);


  return function(dispatch){

    axios.post('http://localhost:3002/api/setProfile', {
        
            username, bio, work, education, mobile, interest
          
          })
         .then((response) => {

              dispatch({
                   type: "EDIT_PROFILE",
                   payload: response.data.status
              }) 

          }).catch((err) => {

             })

  }
}

//Get Profile Details
//SPRING
export function getProfile(username) {

  console.log('PROFILE USERNAME ' + username);

  return function(dispatch){
        axios({
              method:'post',
              url:'http://localhost:8082/api/getProfile',
              withCredentials: true,
              headers: {'Accept': 'application/json','Content-Type': 'application/json'},
              data: username
              
           })
         .then((response) => {
              console.log('AMANNNNNNNNN')
              console.log(response);
              dispatch({
                   type: "GET_PROFILE",
                   payload: response.data
              }) 

          }).catch((error) => {
                  console.log("This is error");
                  return error;
             })
      
  }
}


//Share Files
export function shareFile(file_id,sharedWith) {

  console.log('SHARE FILE_ID ' + file_id);
  
  console.log('SHARE WITH ' + sharedWith);

    return function(dispatch){
          axios({
              method:'post',
              url:'http://localhost:3002/api/shareFile',
              withCredentials: true,
              headers: {'Accept': 'application/json','Content-Type': 'application/json'},
              data: {file_id,sharedWith}
           })
          .then(response => {
          
            
            if(response.status==200){
              dispatch({
                     type: "SHARE",
                    payload: true
                })
              }
              else {
                dispatch({
                     type: "SHARE",
                    payload: false
                })
              } 
          })
          .catch(error => {
              console.log(error);
              return error;
          });
      
  }

}

//Get Shared Files
export function getSharedFile() {

  console.log('SHARE USERNAME ' );
  

  return function(dispatch){

          axios({
              method:'post',
              url:'http://localhost:3002/api/getSharedFile',
              withCredentials: true,
              headers: {'Accept': 'application/json','Content-Type': 'application/json'},
              
           })
          .then((response) => {

              if(response.data.files==undefined){
                  console.log('NO STARRED FILES')
              }
              else {
                dispatch({
                     type: "GET_SHARE",
                     payload: response.data.files
                })
              }

          }).catch((err) => {

             })

  }
}

