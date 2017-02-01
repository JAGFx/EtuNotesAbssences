/**
 * Created by emsm on 01/02/2017.
 */
$( function () {
	var currentStudent = undefined;
	
	$( '.modal-open.new-note' ).click( function ( e ) {
		currentStudent = $( e.currentTarget ).data( 'etuid' );
		console.log( currentStudent );
		
		$( '.modal.newnote' ).modal( 'toggle' );
	} );
	
	$( '.modal.newnote' ).on( 'show.bs.modal', function ( e ) {
		var $this = $( e.currentTarget );
		console.log( $this, currentStudent );
		
		if ( $this === undefined || currentStudent === undefined )
			throw 'Undefined required elements';
		
		$this
			.find( 'form' )
			.attr( 'action',
				$this
					.find( 'form' )
					.data( 'action' ) + currentStudent
			);
	} )
} );