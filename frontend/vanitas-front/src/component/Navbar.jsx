import React, { Component } from 'react';
import icon from '../assets/img/navbaricon.png';

import {
    MDBNavbar,
    MDBContainer,
    MDBNavbarBrand,
    MDBNavbarNav,
} from 'mdb-react-ui-kit';

class Navbar extends Component {
    render() {
        return (
            <>
                <MDBNavbar expand='md' light bgColor='primary'>
                    <MDBContainer>
                        <MDBNavbarNav className='d-flex flex-row align-items-center w-auto'>
                            <MDBNavbarBrand href='#' className='text-white'>
                                <img
                                    src={ icon }
                                    height='50'
                                    alt=''
                                    loading='lazy'
                                />
                            </MDBNavbarBrand>
                            <MDBNavbarBrand className='navbar-brand' style={{color: 'white', fontSize:'200%'}}>
                                <a href='' style={{ textDecoration: 'none', color: 'inherit' }}>
                                    Vanitas
                                </a>
                            </MDBNavbarBrand>
                        </MDBNavbarNav>
                        <MDBNavbarNav className='d-flex flex-row justify-content-center w-responsive'>
                            <MDBNavbarBrand className='text-white'>
                                Türkçe İmla Hatalarını Bulma
                            </MDBNavbarBrand>
                        </MDBNavbarNav>
                            <MDBNavbarNav className='d-flex flex-row justify-content-end w-auto'>
                                <span className='navbar-text' style={{ color: 'rgba(254, 254, 254, 0.6)' }}> teamID:561863 </span>
                            </MDBNavbarNav>
                    </MDBContainer>
                </MDBNavbar>
            </>
        );
    }
}

export default Navbar;
