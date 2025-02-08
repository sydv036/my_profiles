export default function renderSortableUpdate(data) {
    let main = $("#main-profile");
    main.html("");
    if (data == null) {
        main.html(`
          <section class="info row" id="info">
            <div class="col-3 flex-align-center">
              <div class="avartar img-container">
                <img class="avartar_update w100 h100 common-img" src="" alt="" />
                <div class="camera icon-overlay">
                  <i class="fas fa-camera"></i>
                </div>
                <input type="file" hidden class="imgHandle" />
              </div>
            </div>
            <div class="basic-info col-9"></div>
          </section>
          <section class="career-goals" id="career-goals">
            <div
                    class="title-career-goals text-uppercase border-bottom padding-bottom font-size-common color-common text-move-common"
            >
              Mục tiêu nghề nghiệp
            </div>
            <div class="shot-term-goals padding-custom">
              <b
              >Mục tiêu ngắn hạn
                <i class="fas fa-plus-circle icon-custom icon-shot-term-goals">
                  Add New</i
                ></b
              >
              <div class="shot-goal row"></div>
            </div>
            <div class="long-term-goals padding-custom">
              <b
              >Mục tiêu dài hạn
                <i class="fas fa-plus-circle icon-custom icon-long-term-goals"
                >Add New</i
                ></b
              >
              <div class="long-goal row"></div>
            </div>
          </section>
          <section class="education" id="education">
            <div
                    class="education_title text-uppercase border-bottom padding-bottom font-size-common color-common text-move-common"
            >
              Học vấn
              <i
                      class="fas fa-plus-circle icon-custom text-capitalize icon-add-edu"
                      data-bs-toggle="modal"
                      data-bs-target="#modalEducation"
              >Add New</i
              >
            </div>
            <div class="education_info padding-custom"></div>
          </section>
          <section class="skills" id="skills">
            <div
                    class="skills_title border-bottom padding-bottom text-uppercase font-size-common color-common text-move-common"
            >
              Kĩ năng
            </div>
            <div class="skills_name padding-custom">
              <div class="soft-skills">
                <b
                >Kĩ năng mềm
                  <i class="fas fa-plus-circle icon-custom icon-soft-skill"
                  >Add New</i
                  ></b
                >
                <div class="soft_skill_info row"></div>
              </div>
              <div class="professional-skills padding-custom">
                <b
                >Kĩ năng chuyên môn
                  <i class="fas fa-plus-circle icon-custom icon-profess-skill"
                  >Add New</i
                  >
                </b>
                <div class="professional_skill_info row"></div>
              </div>
            </div>
          </section>
          <section class="experience" id="experience">
            <div
                    class="experience_title text-uppercase border-bottom padding-bottom font-size-common color-common text-move-common"
            >
              Kinh nghiệm
              <i
                      class="fas fa-plus-circle icon-custom text-capitalize icon-experience"
              >Add New</i
              >
            </div>
            <div class="experience_info mb-3 padding-bottom"></div>
          </section>
          <section class="project pb-2" id="project">
            <div
                    class="project_title text-uppercase border-bottom padding-bottom font-size-common color-common text-move-common"
            >
              Project
              <i
                      class="fas fa-plus-circle icon-custom text-capitalize icon-add-project"
              >Add New</i
              >
            </div>
            <div class="project_form padding-custom"></div>
          </section>
          <section class="more-information" id="more-information">
            <section class="certificate">
              <div
                      class="certificate_title text-uppercase border-bottom padding-bottom font-size-common color-common text-move-common"
              >
                Certificate
                <i
                        class="fas fa-plus-circle icon-custom text-capitalize"
                        data-bs-toggle="modal"
                        data-bs-target="#modalCertificate"
                >Add New</i
                >
              </div>
              <div class="certificate_info pt-1 padding-bottom"></div>
            </section>
            <section class="hobist">
              <div
                      class="hobist_title text-uppercase border-bottom padding-bottom color-common font-size-common text-move-common"
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
        <div class="col-3 flex-align-center">
              <div class="avartar img-container">
                <img class="avartar_update w100 h100 common-img" src="" alt="" />
                <div class="camera icon-overlay">
                  <i class="fas fa-camera"></i>
                </div>
                <input type="file" hidden class="imgHandle" />
              </div>
        </div>
        <div class="basic-info col-9"></div>
    `);
    $("#career-goals").append(`
            <div
                    class="title-career-goals text-uppercase border-bottom padding-bottom font-size-common color-common"
            >
              Mục tiêu nghề nghiệp
            </div>
            <div class="shot-term-goals padding-custom">
              <b
              >Mục tiêu ngắn hạn
                <i class="fas fa-plus-circle icon-custom icon-shot-term-goals">
                  Add New</i
                ></b
              >
              <div class="shot-goal row"></div>
            </div>
            <div class="long-term-goals padding-custom">
              <b
              >Mục tiêu dài hạn
                <i class="fas fa-plus-circle icon-custom icon-long-term-goals"
                >Add New</i
                ></b
              >
              <div class="long-goal row"></div>
            </div>
    `);
    $("#education").append(`
            <div
                    class="education_title text-uppercase border-bottom padding-bottom font-size-common color-common"
            >
              Học vấn
              <i
                      class="fas fa-plus-circle icon-custom text-capitalize icon-add-edu"
                      data-bs-toggle="modal"
                      data-bs-target="#modalEducation"
              >Add New</i
              >
            </div>
            <div class="education_info padding-custom"></div>
    `);
    $("#skills").append(`
            <div
                    class="skills_title border-bottom padding-bottom text-uppercase font-size-common color-common"
            >
              Kĩ năng
            </div>
            <div class="skills_name padding-custom">
              <div class="soft-skills">
                <b
                >Kĩ năng mềm
                  <i class="fas fa-plus-circle icon-custom icon-soft-skill"
                  >Add New</i
                  ></b
                >
                <div class="soft_skill_info row"></div>
              </div>
              <div class="professional-skills padding-custom">
                <b
                >Kĩ năng chuyên môn
                  <i class="fas fa-plus-circle icon-custom icon-profess-skill"
                  >Add New</i
                  >
                </b>
                <div class="professional_skill_info row"></div>
              </div>
            </div>
    `);
    $("#experience").append(`
            <div
                    class="experience_title text-uppercase border-bottom padding-bottom font-size-common color-common"
            >
              Kinh nghiệm
              <i
                      class="fas fa-plus-circle icon-custom text-capitalize icon-experience"
              >Add New</i
              >
            </div>
            <div class="experience_info mb-3 padding-bottom"></div>
    `);
    $("#project").append(`
            <div
                    class="project_title text-uppercase border-bottom padding-bottom font-size-common color-common"
            >
              Project
              <i
                      class="fas fa-plus-circle icon-custom text-capitalize icon-add-project"
              >Add New</i
              >
            </div>
            <div class="project_form padding-custom"></div>
    `);
    $("#more-information").append(`
        <section class="certificate">
              <div
                      class="certificate_title text-uppercase border-bottom padding-bottom font-size-common color-common"
              >
                Certificate
                <i
                        class="fas fa-plus-circle icon-custom text-capitalize"
                        data-bs-toggle="modal"
                        data-bs-target="#modalCertificate"
                >Add New</i
                >
              </div>
              <div class="certificate_info pt-1 padding-bottom"></div>
            </section>
            <section class="hobist">
              <div
                      class="hobist_title text-uppercase border-bottom padding-bottom color-common font-size-common"
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