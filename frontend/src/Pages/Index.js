import React from 'react';

class Index extends React.Component {
    render() {
        return(
            <div>
                <div id="home" className="section bg-voilet bg-overlay overflow-hidden d-flex align-items-center">
                    <div className="container">
                    
                        <div className="row align-items-center">
                            
                            <div className="col-12 col-md-7 col-lg-6">
                                <div className="home-intro">
                                    
                                    <h1 className="text-white">당신의 계모임을 만들어봐요!</h1>
                                    <p className="text-white my-4">블록체인 기반 계모임 플렛폼 Aramagyeddon에서 당신의 안전한 계모임을 생성하고 사람들을 모아보세요 변경 불가능한 장부를 자동으로 생성하여 여러분의 곗돈을 안전하게 지켜드립니다.</p>
        
                                    
                                    <span className="d-inline-block text-white fw-3 font-italic mt-3">*Armagyeddon 프로젝트의 테스트 인덱스 페이지입니다.</span>
                                </div>
                            </div>
                            <div className="col-12 col-md-5 col-lg-6">
                                
                                <div className="home-thumb mx-auto" >

                                    <img src="/images/asteroid.svg" id="armagyeddon" alt=""/>
                
                                </div>
                            </div>
                        </div>
                    </div>

                 
                </div>


                <div className="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
                    <h1 className="display-4">LET'S GYE IT </h1>
                    <p className="lead">목돈을 만들고 싶다면 계를 만들어보세요!</p>
                </div>

                <div className="container">
                <div className="card-deck mb-3 text-center">
                    <div className="card mb-4 shadow-sm">
                        <div className="card-header">
                            <h4 className="my-0 font-weight-normal">참여중인 계</h4>
                        </div>



                        <button type="button" className="btn btn-lg btn-block btn-outline-primary" onClick="location.href='/gyejoining' ">자세히</button>
                    </div>
                </div>

                <div className="card mb-4 shadow-sm">
                    <div className="card-header">
                        <h4 className="my-0 font-weight-normal" >생성하기</h4>
                    </div>

                    <div className="card-body">


                        <button type="button" className="btn btn-lg btn-block btn-primary" onClick="location.href='/gyecreation' ">+</button>
                    </div>

                </div>

                <div className="card mb-4 shadow-sm">
                    <div className="card-header">
                        <h4 className="my-0 font-weight-normal">참가하기</h4>
                    </div>
                    <div className="card-body">

                        <button type="button" className="btn btn-lg btn-block btn-primary" onClick="location.href='/gyefinder' ">구경하기</button>
                    </div>
                </div>
            </div>

                <section id="stats" className="py-3">
                    <div className="container">
                        <div className="row justify-content-center">
                            <div className="col-5 col-sm-3 text-center">
                                <h1 className="text-voilet"><b>3M</b></h1>
                                <div className="mb-3"></div>
                                <h5>Users</h5>
                            </div>
                            <div className="col-5 col-sm-3 text-center">
                                <h1 className="text-voilet"><b>3M</b></h1>
                                <div className="mb-3"></div>
                                <h5>Users</h5>
                            </div>
                            <div className="col-5 col-sm-3 text-center">
                                <h1 className="text-voilet"><b>3M</b></h1>
                                <div className="mb-3"></div>
                                <h5>Users</h5>
                            </div>
                            <div className="col-5 col-sm-3 text-center">
                                <h1 className="text-voilet"><b>3M</b></h1>
                                <div className="mb-3"></div>
                                <h5>Users</h5>
                            </div>

                        </div>
                    </div>
                </section>
                <section id="features" className="py-5 ">
                    <div className="container">
                        <div className="row justify-content-center mb-5">
                            <div className="col-12 col-md-10 col-lg-7 section-heading text-center">
                                <h5 className="text-voilet mb-4">Premium Features</h5>
                                <h2>What Makes sApp Different?</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laborum obcaecati dignissimos quae quo ad iste ipsum officiis deleniti asperiores sit.</p>
                            </div>

                        </div>

                        <div className="row justify-content-center text-center">
                            <div className="col-12 col-md-6 col-lg-4">
                                <i className="fa fa-bicycle fa-4x text-voilet"></i>
                                <h3 className="mb-2">Fully functional</h3>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Veritatis culpa expedita dignissimos.</p>
                            </div>
                            <div className="col-12 col-md-6 col-lg-4">
                                <i className="fa fa-phone fa-4x text-success"></i>
                                <h3 className="mb-2">Fully functional</h3>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Veritatis culpa expedita dignissimos.</p>
                            </div>
                            <div className="col-12 col-md-6 col-lg-4">
                                <i className="fa fa-coffee fa-4x text-voilet"></i>
                                <h3 className="mb-2">Fully functional</h3>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Veritatis culpa expedita dignissimos.</p>
                            </div>
                        </div>
                    </div>
                </section>
                <section id="services" className=" ">
                    <div className="container">
                        <div className="row justify-content-between align-items-center">
                            <div className="col-12 col-lg-6 ">
                                <h2 className="mb-4">Make your Device Manage Everything For you</h2>
                                <ul className="list-unstyled">
                                    <li><p>Fully layered dolor sit amet, consectetur adipisicing elit. Facere, nobis, id expedita dolores officiis laboriosam.</p></li>
                                    <li><p>Fully layered dolor sit amet, consectetur adipisicing elit. Facere, nobis, id expedita dolores officiis laboriosam.</p></li>
                                    <li><p>Fully layered dolor sit amet, consectetur adipisicing elit. Facere, nobis, id expedita dolores officiis laboriosam.</p></li>
                                    <li><p>Fully layered dolor sit amet, consectetur adipisicing elit. Facere, nobis, id expedita dolores officiis laboriosam.</p></li>

                                </ul>
                            </div>
                            <div className="col-12 col-lg-4 order-1 order-lg-2 d-none d-lg-block">
                                <div className="home-thumb mx-auto">
                                    <img src="/images/partner.svg" alt="" />
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <section id="info" className=" py-5 ">
                    <div className="container">
                        <div className="row justify-content-between align-items-center">
                            <div className="col-12 col-lg-4 ">
                                <div className="mx-auto">
                                    <img src="/images/asteroid_color.svg" alt="" />
                                </div>
                            </div>
                            <div className="col-12 col-lg-6 ">
                                <h2 className="mb-4">Easily communicate with clients using sApp.</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique dolor ut iusto vitae autem neque eum ipsam, impedit asperiores vel cumque laborum dicta repellendus inventore voluptatibus et explicabo nobis unde.
                                </p>
                                <ul>
                                    <li><p>Fully layered dolor sit amet, consectetur adipisicing elit. Facere, nobis, id expedita dolores officiis laboriosam.</p></li>
                                    <li><p>Fully layered dolor sit amet, consectetur adipisicing elit. Facere, nobis, id expedita dolores officiis laboriosam.</p></li>
                                    <li><p>Fully layered dolor sit amet, consectetur adipisicing elit. Facere, nobis, id expedita dolores officiis laboriosam.</p></li>
                                    <li><p>Fully layered dolor sit amet, consectetur adipisicing elit. Facere, nobis, id expedita dolores officiis laboriosam.</p></li>
                                </ul>
                            </div>

                        </div>
                    </div>
                </section>
                <section id="features" className="py-5 bg-voilet text-white">
                    <div className="container">
                        <div className="row justify-content-center mb-5">
                            <div className="col-12 col-md-10 col-lg-7 section-heading text-center">
                                <h5 className="text-voilet mb-4">Premium Features</h5>
                                <h2>What Makes sApp Different?</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laborum obcaecati dignissimos quae quo ad iste ipsum officiis deleniti asperiores sit.</p>
                            </div>

                        </div>

                        <div className="row justify-content-center text-center">
                            <div className="col-12 col-md-6 col-lg-4">
                                <i className="fa fa-bicycle fa-4x text-white"></i>
                                <h3 className="mb-2">Fully functional</h3>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Veritatis culpa expedita dignissimos.</p>
                            </div>
                            <div className="col-12 col-md-6 col-lg-4">
                                <i className="fa fa-phone fa-4x text-white"></i>
                                <h3 className="mb-2">Fully functional</h3>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Veritatis culpa expedita dignissimos.</p>
                            </div>
                            <div className="col-12 col-md-6 col-lg-4">
                                <i className="fa fa-coffee fa-4x text-white"></i>
                                <h3 className="mb-2">Fully functional</h3>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Veritatis culpa expedita dignissimos.</p>
                            </div>
                        </div>
                    </div>
                </section>
                <section id="features" className="py-5">
                <div className="container">
                    <div className="row justify-content-center mb-5">
                        <div className="col-12 col-md-10 col-lg-7 section-heading text-center">
                            <h5 className="text-voilet mb-4">Premium Features</h5>
                            <h2>Frequently Asked Questions</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laborum obcaecati dignissimos quae quo ad iste ipsum officiis deleniti asperiores sit.</p>
                        </div>

                    </div>
                    <div className="row mb-5">
                        <div className="col-12 col-md-6">
                            <div className="faq-items">
                                <h4> How to install sApp?</h4>
                                <p>The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text.</p>
                            </div>
                            <div className="faq-items">
                                <h4> How to install sApp?</h4>
                                <p>The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text.</p>
                            </div>
                            <div className="faq-items">
                                <h4> How to install sApp?</h4>
                                <p>The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text.</p>
                            </div>
                        </div>
                        <div className="col-12 col-md-6 justify-content-center">
                            <div className="faq-items">
                                <h4> How to install sApp?</h4>
                                <p>The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text.</p>
                            </div>
                            <div className="faq-items">
                                <h4> How to install sApp?</h4>
                                <p>The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text.</p>
                            </div>
                            <div className="faq-items">
                                <h4> How to install sApp?</h4>
                                <p>The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text.</p>
                            </div>
                        </div>

                    </div>


                </div>
            </section>
            </div>
        );
    }
}

export default Index;