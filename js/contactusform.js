function check(){
    
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var contactnumber = document.getElementById("contactnumber").value;
    var website = document.getElementById("website").value;
    var message = document.getElementById("message").value;
    const validRegexEmail = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    const validRegexVIPhoneNumber=/([\+84|84|0]+(3|5|7|8|9|1[2|6|8|9]))+([0-9]{8})\b/;
    let text;
    
    if(email.length==0){
        document.getElementById("erroremail").style.visibility="visible";
    }else if(!email.match(validRegexEmail)){
        document.getElementById("erroremail").textContent="please fill a valid email";
        document.getElementById("erroremail").style.visibility="visible";
    }
    else{
        document.getElementById("erroremail").style.visibility="hidden";
    }
    if(name.length==0){
        document.getElementById("errorname").style.visibility="visible";
    }else{
        document.getElementById("errorname").style.visibility="hidden";
    }
    if(contactnumber.length==0){
        document.getElementById("errorcontactnumber").style.visibility="visible";
    }else if(!contactnumber.match(validRegexVIPhoneNumber)){
        document.getElementById("errorcontactnumber").textContent="please fill a valid Phone Number";
        document.getElementById("errorcontactnumber").style.visibility="visible";
    }
    else{
        document.getElementById("errorcontactnumber").style.visibility="hidden";
    }
    if(website.length==0){
        document.getElementById("errorwebsite").style.visibility="visible";
    }else{
        document.getElementById("errorwebsite").style.visibility="hidden";
    }
    if(message.length==0){
        document.getElementById("errormessage").style.visibility="visible";
    }else{
        document.getElementById("errormessage").style.visibility="hidden";
    }
    }