import React, { useState } from 'react';
import { MDBBtn, MDBPopover, MDBPopoverBody } from 'mdb-react-ui-kit';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faLinkedinIn, faGithub } from '@fortawesome/free-brands-svg-icons';
function LinkedInButton() {
    return (
        <div style={{ display: 'flex', flexDirection:'column', justifyContent: 'center', width: '100%' }}>
                <MDBPopover placement="top" size='sm' color='primary' btnChildren='LinkedIn'>
                    <MDBPopoverBody>
                        <a href="https://www.linkedin.com/in/osman-batur-arpacik/" className="btn btn-primary"
                           style={{backgroundColor: '#0082ca'}}
                           role="button">
                            <FontAwesomeIcon icon={faLinkedinIn}  className="fab fa-github fa-2x" />
                        </a>
                        <button className="btn btn-link" color="primary" style={{ textDecoration: 'none'}}>
                            <a href="https://www.linkedin.com/in/osman-batur-arpacik/" style={{ textDecoration: 'none'}}>
                                Osman Batur <br/>Arpacık
                            </a>
                        </button>
                        <br/>
                        <br/>
                        <a href="https://www.linkedin.com/in/yunus-oz-90326169/" className="btn btn-primary"
                           style={{backgroundColor: '#0082ca'}}
                           role="button">
                            <FontAwesomeIcon icon={faLinkedinIn}  className="fab fa-github fa-2x" />
                        </a>
                        <button className="btn btn-link" color="primary" style={{ textDecoration: 'none'}}>
                            <a href="https://www.linkedin.com/in/yunus-oz-90326169/" style={{ width: '100%' ,display: 'flex', flexDirection: 'row', justifyContent: 'center', textDecoration: 'none', color: 'inherit', padding: '0 20% 0 50%' }}>
                                Yunus Öz
                            </a>
                        </button>
                    </MDBPopoverBody>
                </MDBPopover>
        </div>
    );
}
function GitHubButton() {
    return (
        <div style={{ display: 'flex', flexDirection:'column', justifyContent: 'center', width: '100%' }}>
                <MDBPopover placement="top" size='sm' color='dark' btnChildren='GitHub' style={{ color: '#FFFFFF'}}>
                    <MDBPopoverBody>
                        <a href="https://github.com/OsmanBaturArpacik" className="btn btn-primary"
                           style={{backgroundColor: 'black'}}
                           role="button">
                            <FontAwesomeIcon icon={faGithub} className="fab fa-github fa-2x" style={{color: 'white'}}/>
                        </a>
                        <button className="btn btn-link" color="primary" style={{ textDecoration: 'none'}}>
                            <a href="https://github.com/OsmanBaturArpacik" style={{textDecoration: 'none'}}>
                                Osman Batur <br/>Arpacık
                            </a>
                        </button>
                        <br/>
                        <br/>
                        <a href="https://github.com/ozyunus" className="btn btn-primary"
                           style={{backgroundColor: 'black'}}
                           role="button">
                            <FontAwesomeIcon icon={faGithub} className="fab fa-github fa-2x" style={{color: 'white'}}/>
                        </a>
                        <button className="btn btn-link" color="primary" style={{ textDecoration: 'none'}}>
                            <a href="https://github.com/ozyunus" style={{ width: '100%' ,display: 'flex', flexDirection: 'row', justifyContent: 'center', textDecoration: 'none', color: 'inherit', padding: '0 20% 0 50%' }}>
                                Yunus Öz
                            </a>
                        </button>
                    </MDBPopoverBody>
                </MDBPopover>
        </div>
    );
}

export { LinkedInButton, GitHubButton };
