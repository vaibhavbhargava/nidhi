$("#myformsubmit").click(function(e){
    e.preventDefault(),
    $.ajax({
      type: 'POST',
      url: "/bin/form-submit-servlet.json",
      data: $("#myform").serialize(), 
      success: function(response) {
          $(".thankyouMessage").show();
          $(".myform").hide();
      },
      error: function() {
            $(".errorMessage").show();
			$(".myform").hide();
      }
    });
});