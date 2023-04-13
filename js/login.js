function check(){
    
    
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    const validRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    let text;
    
    if(email.length==0){
        document.getElementById("checknullemail").style.visibility="visible";
    }
    if(password.length==0){
        document.getElementById("checknullpassword").style.visibility="visible";
    }
    if(!email.match(validRegex)){
        document.getElementById("checkvalidemail").style.visibility="visible";
    }
    if(password.length<6){
        document.getElementById("checkvalidpassword").style.visibility="visible";
    }
    }