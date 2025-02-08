export default function renderSortable(data) {
    let main = $("#main-profile");
    main.html("");
    if (data == null) {
        main.html(`
            <section class="info row">
                <div class="img col-3 flex-align-center">
                    <div class="avartar">
                        <img
                                class="image common-img w100 h100 border-radius-50"
                                src="https://placehold.co/100"
                                alt=""
                        />
                    </div>
                </div>
                <div class="basic-info col-9"></div>
            </section>
            <section class="career-goals"></section>
            <section class="education"></section>
            <section class="skills"></section>
            <section class="experience"></section>
            <section class="project"></section>
            <section class="more-information">
                <section class="certificate"></section>
                <section class="hobist">
                    <div
                            class="hobist_title text-uppercase border-bottom margin-bottom color-common font-size-common"
                    >
                        hobist
                    </div>
                    <div class="hobist_info">
                        <ul>
                            <li>ĐÁ BÓNG</li>
                            <li>CẦU LÔNG</li>
                            <li>BƠI</li>
                        </ul>
                    </div>
                </section>
            </section>
        `);
        return;
    }
    data.forEach(item => {
        main.append(`
         <section class="${item}" id="${item}" ></section>
       `)
    });
    $("#info").addClass("row");
    $("#info").append(`
         <div class="img col-3 flex-align-center">
            <div class="avartar">
                <img
                        class="image common-img w100 h100 border-radius-50"
                        src="https://placehold.co/100"
                        alt=""
                />
            </div>
        </div>
        <div class="basic-info col-9"></div>
    `);
    $("#more-information").append(`
        <section class="certificate"></section>
        <section class="hobist">
            <div
                    class="hobist_title text-uppercase border-bottom margin-bottom color-common font-size-common"
            >
                hobist
            </div>
            <div class="hobist_info">
                <ul>
                    <li>ĐÁ BÓNG</li>
                    <li>CẦU LÔNG</li>
                    <li>BƠI</li>
                </ul>
            </div>
        </section>
    `);
}