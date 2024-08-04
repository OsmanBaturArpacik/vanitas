import React from 'react';
import {
    MDBFooter,
    MDBContainer,
    MDBCol,
    MDBRow,
} from 'mdb-react-ui-kit';

import {LinkedInButton, GitHubButton} from './ContactButtons';

const Footer = () =>
    <MDBFooter className='text-white' style={{ backgroundColor: 'rgba(58,131,204,0.61)'}}>
            <MDBContainer className='p-4'>
                <MDBRow>
                    <MDBCol lg="10" md="12" className='mb-4 mb-md-0'>
                        <h5 className='text-uppercase'>Proje Hakkında</h5>
                        <p>
                            Bu proje, kullanıcıdan alınan bir başlangıç URL'si üzerinden başlayarak web scraping ile ilgili işlemleri gerçekleştirir.
                            Başlangıç URL'si içinde bulunan diğer URL'leri tespit eder ve belirli bir domain ile aynı uzantıya sahip olanları filtreler.
                            Ardından bu URL'leri ziyaret ederek sayfa içeriğini HTML olarak alır ve bu HTML kodlarını parse ederek metin haline getirir.
                            Elde edilen metin verilerini Zemberek, Morphology ve normalizasyon gibi doğal dil işleme tekniklerini kullanan bir API'ye gönderir.
                            API'den gelen dil işleme sonuçlarını kullanarak öneriler elde edilir.
                        </p>
                    </MDBCol>
                    <MDBCol lg="1" md="6" className='mb-4 mb-md-0'>
                        <h5 className='text-uppercase' style={{ display: 'flex', flexDirection:'column', justifyContent: 'center', alignItems: 'center' }} >Linkler</h5>
                        <ul className='list-unstyled mb-0'>
                            <li>
                                <LinkedInButton />
                            </li>
                            <br/>
                            <li>
                                <GitHubButton />
                            </li>
                        </ul>
                    </MDBCol>
                </MDBRow>
            </MDBContainer>
            <div className='text-center p-2' style={{ backgroundColor: 'rgba(0, 0, 0, 0.2)', color: 'rgba(254, 254, 254, 0.5)' }}>
                © 2024 Copyright: &nbsp;
                <a href='https://github.com/OsmanBaturArpacik' style={{ textDecoration: 'none', color: 'rgba(254, 254, 254, 0.8)', fontFamily: 'inherit' }}>
                    Vanitas
                </a>
            </div>
        </MDBFooter>


export default Footer