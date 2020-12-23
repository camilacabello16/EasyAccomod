function addText()
{
    //var username = document.getElementById('u').value;
    var msg = document.getElementById('msg-cnt').value;
    olist = document.getElementById('list');
    op = document.createElement('p');
    op.innerHTML = "test" + "- <g>" + msg + "</g>";
    ocontent = document.getElementById('chatFrame');
    ocontent.appendChild(op);             //Add new line on click
    olist.scrollTop = olist.scrollHeight; //Adjust Height
    document.getElementById('msg-cnt').value = '';
    var xmlhttp;
    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.open("POST", "chatstore?uname=" + "test" + "&msg=" + msg, true);

    xmlhttp.onreadystatechange = function()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
        {
            console.log("OK");
        }
    }
    xmlhttp.send(null);
}