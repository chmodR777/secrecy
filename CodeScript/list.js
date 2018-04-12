function fncListRowOver( intRowNo, intMouseFlag ){
	if( intMouseFlag == 1 ){
		document.all.item( "ListRow", intRowNo ).style.color			= "#ffffff";
		document.all.item( "ListRow", intRowNo ).style.backgroundColor	= "#20b2aa";
	}
	else {
		document.all.item( "ListRow", intRowNo ).style.color			= "#000000";
		document.all.item( "ListRow", intRowNo ).style.backgroundColor	= "#EEEEFF";
	}
}

function fncListRowClick( strAddress ){
	parent.location.href = strAddress;
}
