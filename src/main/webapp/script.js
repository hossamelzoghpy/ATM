/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function redirect(link)
{
    if(link === "index")
    {
        alert("Your Data Has Been Subited")
        setTimeout(function(){
            window.location.href = "index.jsp";
        },5000)
    }
    else{
         window.location.href = `${link}`;
    }
}
function addAction(link)
{
    const indexForm = document.querySelector(".index_form");
    indexForm.action = `${link}`
    indexForm.submit();
}
function generatePDF() {
        const element = document.querySelector('.register');
        var opt = {
  margin:       1,
  filename:     'AccountDetails.pdf',
  image:        { type: 'jpeg', quality: 0.98 },
  html2canvas:  { scale: 5 },
  jsPDF:        { unit: 'in', format: 'letter', orientation: 'landscape' }
};

// New Promise-based usage:
html2pdf().set(opt).from(element).save();

// Old monolithic-style usage:
//        html2pdf()
//            .from(element)
//            .save();
}
function msg(msg)
{

    alert(`${msg}`);
   
}


