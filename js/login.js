function check(){
    
    
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    const validRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    let text;
    
    if(email.length==0){
        document.getElementById("checknullemail").style.visibility="visible";
    }else if(!email.match(validRegex)){
        document.getElementById("checknullemail").textContent="xin nhập đúng định dạng email";
        document.getElementById("checknullemail").style.visibility="visible";
    }else{
        document.getElementById("checknullemail").style.visibility="hidden";
    }
    if(password.length==0){
        document.getElementById("checknullpassword").style.visibility="visible";
    }else if(password.length<6){
        document.getElementById("checknullpassword").textContent="xin nhập mật khẩu dài hơn 6 ký tự";
        document.getElementById("checknullpassword").style.visibility="visible";
    }else{
        document.getElementById("checknullpassword").style.visibility="hidden";
    }
    
    
    }