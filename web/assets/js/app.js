/**
 * Created by emsm on 01/02/2017.
 */
$( function () {
	var currentStudent = undefined;
	var initialized = false;
	
	$( ".datetimepicker" ).datetimepicker( {
		format:     'yyyy-mm-dd hh:ii',
		autoclose:  true,
		minuteStep: 10,
		startDate:  new Date()
	} );
	
	if ( !initialized ) {
		$( '#showNotes' )
			.bootstrapToggle( 'on' );
		
		$( '#showAbsences' )
			.bootstrapToggle( 'off' );
		$( '.groupAbs' ).hide();
		
		initialized = true;
	}
	
	
	// ----------------------------------------------------- Notes
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
	} );
	
	$( '#showNotes' )
		.change( function () {
			var obj = $( this );
			
			if ( !obj.prop( 'checked' ) ) {
				$( '.groupNote' ).hide();
				obj.prop( 'checked', false );
			}
			else {
				$( '.groupNote' ).show();
				obj.prop( 'checked', true );
			}
		} );
	
	
	// ----------------------------------------------------- Absence
	$( '.modal-open.new-abs' ).click( function ( e ) {
		currentStudent = $( e.currentTarget ).data( 'etuid' );
		console.log( currentStudent );
		
		$( '.modal.newabsence' ).modal( 'toggle' );
	} );
	
	$( '.modal.newabsence' ).on( 'show.bs.modal', function ( e ) {
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
	} );
	
	$( '#showAbsences' )
		.change( function () {
			var obj = $( this );
			console.log( obj );
			
			if ( !obj.prop( 'checked' ) ) {
				$( '.groupAbs' ).hide();
				obj.prop( 'checked', false );
			}
			else {
				$( '.groupAbs' ).show();
				obj.prop( 'checked', true );
			}
		} );
} );