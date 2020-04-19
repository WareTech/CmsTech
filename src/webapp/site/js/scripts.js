$( document ).ready(function() {
	loadCategories();
});

function loadCategories()
{
   $.get( "/CmsTech/services/CategoryList.jsp", function( data ) {
		setCategories(data);
	});
}

function setCategories(data)
{
	var categories = $.parseJSON(data); 
	var ul = $('#categories');
	$.each(categories, function(i, item) 
	{
		ul.append('<li><a href="categoria.html" data-thumb-preview="../img/demos/shop/previews/home1.jpg">' + item.name + '</a></li>');
	});
}