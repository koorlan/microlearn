--ACCOUNT
INSERT INTO ACCOUNT ( type,login, password,firstname, lastname) 
VALUES 
('TEACHER','teacher1','f2d81a260dea8a100dd517984e53c56a7523d96942a834b9cdc249bd4e8c7aa9','John','DOE'),
('TEACHER','teacher2','f2d81a260dea8a100dd517984e53c56a7523d96942a834b9cdc249bd4e8c7aa9','Joe','SUZY'),
('ADMIN','admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','admin','admin'),
('STUDENT','student1','f2d81a260dea8a100dd517984e53c56a7523d96942a834b9cdc249bd4e8c7aa9','Kung','FURY'),
('STUDENT','student2','f2d81a260dea8a100dd517984e53c56a7523d96942a834b9cdc249bd4e8c7aa9','Homer','SIMPSON');

--MODULE
INSERT INTO PUBLIC.MODULE(ID, CONTENT, TITLE, TEACHER_LOGIN) VALUES
(1, 'le triangle et plus encore', 'Module 1 : Le Triangle', 'teacher1'),
(2, 'Pour en finir avec les angles droits', 'Module 2 : Le Rectangle', 'teacher1'),
(3, 'Nous allons voir les secrets de l eau', 'Module 3 : Eau dans son milieu', 'teacher2');

--FOLLOW
INSERT INTO PUBLIC.FOLLOWING(FOLLOWERS_LOGIN, FOLLOWEDMODULES_ID) VALUES
('student1', 1),
('student2', 1),
('student1', 2),
('student2', 3);      

--CHAPTER
INSERT INTO PUBLIC.CHAPTER(ID, CONTENT, POSITION, TITLE, MODULE_ID) VALUES
(1, STRINGDECODE('# Saxa naufragus vocisque ferrum vult fulmine\r\n\r\n## Animam deduxit negaverit aspexisse pisce\r\n\r\nLorem markdownum femina Phoce: nec mihi per\r\n[virgine](http://caelebshonore.org/tolles-aequora) quae. Sulphure Phineus\r\nbracchia socium, ipsa caerula Oliaros insiluit. Est dedisse ensis gutture\r\ndefensore munusque sustulit tenvit ut inquit Sparten.\r\n\r\n1. Est quas quamvis quae nunc et cura\r\n2. Colla sim gaudent Dianae utinamque queror\r\n3. Nusquam tellus Hellespontus satis acres\r\n\r\n## Nate discutit natos et Troiam est\r\n\r\n*Tempora* docta mortale trepidante prohibete iterum in alis, sic te? Nec [haec\r\nradice satae](http://www.necpellis.net/) paranti rictuque relinquit, erat super\r\nPyracmon iam campos, [non\r\nhaec](http://spiculaerymantho.org/manuspromunturiumque) serpentis.\r\n\r\n- Nocuit et cui vini pectora timide dixit\r\n- Iocosa oculis versa virgine dementer postquam soleant\r\n- Velatos arma litora adsumere verum supponas suo\r\n- Inmansuetumque equi stabant\r\n- Totiens Agre poenam saevo Theseus corpora malis\r\n\r\nMoveant est rex ademi osculaque restant dubio supersunt fregit o erant\r\ngenerique, tunc. Talia haustos mucro, regno multa moenia quae debes erroris\r\nobductos.\r\n\r\n## Qua quem expositum\r\n\r\nAit ex virgo iugo corpus cuspide, hunc, **sed**. Litoream salutent decipis at\r\ntria ausus subiectas in medii, titubantis securi. Undae spargensque adiecisset\r\net motibus **tellure** curvis ululatibus quo leniat **frugum** Poeantia:\r\n**femina** curae. Ter **cui fuit movere** lacrimis arte animam, per in penetrale\r\ncontermina.\r\n\r\n- Pectus bicolor parat per\r\n- Et et communemque communem nobis luctuque Caicus\r\n- Ubi armos in hic sua quoque\r\n- Munus a flores totidemque in incepto flumine\r\n- Addere aut sua vulnere\r\n- Unum falsosque quorum\r\n\r\nHumano unda; *poenam me* nymphe negate. Sua esse deducunt et frena Alemone\r\nPerseus dimovit adventu superis Bubasides lumina primum.'), 1, 'Chapitre 1 : Les bases', 1),
(2, STRINGDECODE('# Iaculum est Talibus missa\r\n\r\n## Liternum talibus\r\n\r\nLorem markdownum librato puer fassoque vestram accipite, defendit habuit; non.\r\nQuae umbras grates, aper saxi sumit, vela patiere, cura potuit?\r\n\r\n1. Femori ortu\r\n2. Nomine afueram inpune mutavit deorum nescit\r\n3. Usum tulimus fama turbam igni\r\n4. Maia et fides aquis sperataque tepido\r\n5. Sonumque conscia ait Sirenes agros tamen\r\n\r\n## Nudare iniustus colorem inevitabile\r\n\r\nEt adversae evertere audentes Bacchi *hodierna longoque*, rectoque flore quoque:\r\nadduxit? Egit perdere ianua stabantque vis loquaci memores decipit, [aegide\r\nIcarus](http://nunc.net/per-cumque)! Temptent vallis supponitur pondere [torvis\r\nfronde](http://colle-meritis.com/coniugis-parvis.html), exaudi et tantos imagine\r\ninsilit nec omnem.\r\n\r\n- Et dicere pastae iunguntur iuvenco fecerat\r\n- Opertum protinus\r\n- Ne ac Pergama ultima dolisque frondes dividite\r\n\r\n## Agmina et monstri quas sinistra est redit\r\n\r\nManusque avidum preces, aptarique quoniam et antiquae: domini et et relinquant.\r\nDixit tua grata fago vivo sua, bracchia fati miserande. Solis adfectas. Acri\r\nUlixem abnuit auguror his mihi cadentum erat; lupi! *Plurimus* ense adest dedere\r\nfilo timidum, delamentatur canem: generosi.\r\n\r\n- Aevo Giganteo illud oculos\r\n- Nexibus natamque\r\n- Conveniant mors freta telorum et uvae cum\r\n- Dare erat novae cornibus evicere saxoque sic\r\n- Fugit Abas Anchisae ibimus vocem\r\n- Corpus lupum\r\n\r\nAltis Phaethusa, Bacchus revellit et datae adstitit, et tectis! Igni artus\r\ngenitor loquor; non caesus auctor scylla, post tenet arma [reppulit amnes\r\nsole](http://retenta.io/celandacrevit.html). Pereat formam animosque quia:\r\nserisque quicquid totidemque undis, retro, exhorruit? Inter laudis convicia\r\nquamquam iussa si te est, non decimum misi.'), 2, 'Chapitre 2 : Un peu plus loin', 1),
(3, STRINGDECODE('# Sed res facinus usum\r\n\r\n## Pleiadum oculisque quanto\r\n\r\nLorem markdownum, illa ipsis coniuge caedis cantibus Athenas paret di Danaos.\r\nPecorum damno neque aggere hunc optat pudore dimissis, illo gurgite dolebat sic\r\nmotus studiumque verbaque! Ipse adeat vultus idem; ac auras Thybridis contigit,\r\ndistantes dulcedine, contortum subnixa si ne.\r\n\r\n> Auras *piosque* natae stipata dextera. Cur Argo Cephisos, corpora Taygetenque\r\n> quod committat natam nullo erat multo *in* apertum pater impatiens vidit.\r\n> Petebamus adpositis pectora summis curru, et est dederat sacrata recalfecit\r\n> est virginea. Ne lusisse genitus, hoc vagatur erat **tumuletur igneus inania**\r\n> Ceyx erigitur dixerat atque patri e vincere, spectatorem? Nymphae prohibent\r\n> pressa, fundit austroque labore pectora, exsistunt et sensi rurigenae unius\r\n> fruges adducitque!\r\n\r\n## O nec uni ferrum quae non illum\r\n\r\nTexebas in hostia *recumbere cecidere* ille, contenta vibrata tempora leto\r\nmiseri. Silicem sed mentiris moras placidis latet dolor haec erit vagans!\r\nRamisque et, iuro tanti matrem, adulterio *aurum iunctissima* alis: quoque\r\nlatebras requirit Cancrum tales in subibis. Cognosces albis et sic, mora,\r\ncadendum, modo **nuda confido**. Fecisse armiger vota tutam vigil Neptunia et\r\nignavi de *Ulixes* deferre mitissimus obambulat *coniunx requirit*, Cythereide\r\nfuit!\r\n\r\n    infringement_reciprocal -= edi_document(sms_data, signatureBashSector) +\r\n            dragBmp(page_horse, minicomputer, file);\r\n    var software_disk_hard = thunderboltLeafEngine(teraflops_minimize(system,\r\n            namespace, 55), postscriptBloatwareDisk, of_page_username(2));\r\n    synSmtp(86 + captcha(vduServices, honeypot_pack), drive_mca_supply,\r\n            wordartEpsMultiplatform);\r\n    var e_bloatware_server = storageMidi(filename);\r\n\r\n## Et hoc valle undaeque et licet quoque\r\n\r\nTandem *est suisque vertit*, illis Syenites et fratres elusam nymphae cogor at\r\nigni sociam benefacta graviore petis. Vis [postquam\r\ncum](http://diuarabas.org/cladis.html) et quadrupes accipe per portas aquis, tum\r\net quam.\r\n\r\n- Tardis tamen artus annum\r\n- Inhonoratae flores Pithecusas veteris\r\n- Hos tantique longum adhuc effodiuntur carmen flavaque\r\n- Occupat factum spectat praecepta superant citharae et\r\n- Secuta ulciscor in inpedit pietate insidiisque aut\r\n\r\nSolidam unum Lacon reperire derepta sulphure; est de illa venit domo, cui nube\r\ncernitis labori, nos me. Spiritus facit **disicit recurvatis infelix**\r\namplectitur Ilion, et haec mundi [modo sit](http://famategumen.org/et), tenuit.\r\n**Tetigere sudore**, quacumque et quae detestatur velle, et regnat tibi timeo\r\ninferias tu valet si abesse mandata. Repellit tertia mutantur, sum illam\r\npenduntque Cererem fronte pennis animos.'), 3, 'Chapitre 3 : Pour finir...', 1);             
INSERT INTO PUBLIC.CHAPTER(ID, CONTENT, POSITION, TITLE, MODULE_ID) VALUES
(4, STRINGDECODE('# Ipse qua ostendens nosset Agenorides\r\n\r\n## Erat retia in habet\r\n\r\n[Lorem](http://mediis-est.net/stat-timores) markdownum classis arvum: ossa\r\niuvenem quae exhalantem haerent; mediae sentite! Iubet deprensa curvamine sunt,\r\nhis dubitaret annis operire merces.\r\n\r\nFluit est reddunt gelidum voluptas dempserat et egentes motu. Origo viae ferox\r\nmemorant Ampyx indoluisse vocat interius et Hebre, tibi. Illa occupat nec\r\nnumquam loqui, ipse, sed se moenia petisset feruntur. Pharetras de mihi **quod\r\nfugiens possim** tamen obortis, est digiti! Tenebat neve iam videbitur texerat\r\nhostis moventem fulvae victus officium in erat et displicet.\r\n\r\nAutumnos *multos et* utroque et medio spectacula, nymphae pedis. Aura stagna\r\nmihi, secedere. Precor effundite iudice **et placuisse non**, iam proelia\r\npronos; **poterat sit**, aduncis fuerunt **puellis**!\r\n\r\n## Cardine modo urbis ut inania bracchia mortalem\r\n\r\nAit cur cadentibus, non Naxon se positoris Marte regnumque te videri nataeque\r\nlongusque migrare omnes *nolet*. Frustra ferro in nomenque dedit tot: in magnos\r\nhabens ferrum firmamina gradus [mutavit iactu\r\nfecere](http://www.genustinxerat.net/) victa densis callidus. Accepere sed et\r\nintonsum deprensi cernimus fidumque. Passurae sanguis sede ibis proles sorores\r\n**meus Ditis** tuas, hic vera spectes tollens mixtoque Bromiumque multi se\r\nnoscit.\r\n\r\n> Namque huc cuius dicit maneat speret tepentibus laniem. Dum anni Phoenix, non\r\n> deam fieret, manifesta querenda postulat adclivi signum. Crudelia amplius ab\r\n> Indis speciem oscula ostendi conchae glandes, umbrae est.\r\n\r\nDeorum *segetes*. Tunc vacca pressit. Movetur si iacens ossibus: duro\r\n[exemploque viribus](http://extulit.org/est-iamiam.php), aequi. Sequens et\r\nvulnus partes, per iam nostras hanc: amore. Quod ipsi aquae suo: dente Ulixe\r\npronus, tu petis resistit: qui vocatur, est.\r\n\r\nNostra ire in Nereides nec, solutus! Ille vocet viscera dubites animam.\r\n\r\nCur conspecta caesis pumice praecessit Solis posses regia et permanet sine,\r\nperagant. Paulatim aequoreis cervice alumnae hanc ferrugine secuti moenia,\r\nindulgere undas stagnare Venerem.'), 1, 'Chapitre 1 : Les bases', 2),
(5, STRINGDECODE('# Brevis in sua moriturae habenis\r\n\r\n## Aliis quam laetatur manu\r\n\r\nLorem markdownum quidem? Si duobus quam arbore [laborum\r\ngratia](http://telismoratur.net/postquam), et iecit non Lyncidae dissimulat tria\r\nHector enim. **Pugnae** deprensum et omnes Curetas? Viro quondam Phrygiis\r\nLavinia quasque inde, ore est magno, palmiferos sagittis Actaeon virtus exit\r\ntumidum rebelles illis.\r\n\r\n    nybble_controller_pcb = 1;\r\n    var gateMysql = programmingClob;\r\n    var golden = spyware_user_mail(clipboard_font * proxy_bin_java + gigo_menu(\r\n            httpDvd, record, number), -2, desktop);\r\n    touchscreen(service(frozen, pim_num, mediaDMedia * -2));\r\n    if (scroll + token / recursion_javascript > inbox_network) {\r\n        partition_dram_fat(open_expression + system_point);\r\n    }\r\n\r\n## Flebant regni hoc iramque illuc repurgato subiecta\r\n\r\nTer scilicet *tenet contingent prohibere* unus, ita tectoque aede Troades,\r\ntremit? Turbatus sic opus, exululatque tamen consanguineas caede domusque\r\ntamquam fuit: hic. In lavere exstinctum imagine decurrere ut inquit curvantem in\r\nquae. Seduxit faciem potiturque rapis collumque flammis Phaestiadas Hippodamen\r\nveris et quamvis. Bella facies in alma signum, primaque, perstat, alta [quis\r\nspatio](http://purpureusquepater.org/et) agmen operiri Troius disparibus\r\nrevulsos utrumque?\r\n\r\n    kilohertz_server_version -= osiArchiveLink - compressionPop(1, adf_bounce,\r\n            sprite.toslinkTopology(3, java));\r\n    file_page.flash_monochrome_ipod.archie_isa(-2 / pcmciaOlapTypeface /\r\n            technology_display, login_arp);\r\n    systemMemoryInbox -= column_column_publishing;\r\n    var paritySecondary = 3;\r\n\r\n## Domus laesi mihi ulterius genitor inprovisoque induruit\r\n\r\nDespicit avenis: nec et vehi celeres tactae iuncis; dum clara morti tangamque\r\nexstinguor [colle](http://utinam-ut.com/ignes-troiaeque.html): miser sola!\r\nUtinam vitiantur sustinet donec Cerealis superinposita intrarit\r\n[et](http://www.reficisque-cornu.com/chordas.html) illi. Mihi posse senioribus\r\nquaque crevit caput alis Deucalion, has ante, et tyranno Oenopiam inter,\r\ninscius. **Rapit tum** neque pro, a ordine, tuam enim.\r\n\r\n1. Nemus vultibus tophis in et quod ferunt\r\n2. Facientes placuit domuisse\r\n3. Quae ego propior missa pando primum levia\r\n4. Esset Romana\r\n\r\nMinus unda urnam ora Achivis fictis *vidit* sententia in Mycenae habuit tuas\r\nincubat iurare, et a postquam. Dixit oracula.'), 2, 'Chapitre 2 : Un peu plus loin', 2);            
INSERT INTO PUBLIC.CHAPTER(ID, CONTENT, POSITION, TITLE, MODULE_ID) VALUES
(6, STRINGDECODE('# Doles roratis multi vocem\r\n\r\n## Cristae aliquid fidissima humana\r\n\r\nLorem markdownum percussit intrat coniuge Tellus quid neglectos apta liquitur,\r\nsummaque, quem ruit vernos egere voluit, te? Est caelestia pelagi septemplice\r\nnumina fortissima iussit reddentemque flere in *Iovi*.\r\n\r\n1. Restitit illa\r\n2. Utque reseratis ligno contemptaque quid gerere faeno\r\n3. Parva tectaque caerulus corde adicit cum aequo\r\n\r\nArvis lucis quidem verba est exemploque admonita veluti! Iurgia male; modo\r\nAeolon mortale. Amabam concessa. Situ visa sed mortis urbem albentibus divis,\r\nvinxerat: *excussa litore*. Est herbosa cupido, sed tellure, valvas Lyrcea\r\nexquirere Pentheus coeunt permulsit.\r\n\r\n    var eccTft = partyMetafileNetmask.direct(nat_vga, clobDocking - 4, voip);\r\n    architectureUrl = spreadsheet_mirrored(boolean_whitelist_computer(4,\r\n            codec_control) * link, dllProgressiveAutoresponder(4, ide_hacker),\r\n            bing_postscript);\r\n    dvPhp(ray(-4, mirrored_localhost_vdu, saasPcmcia));\r\n    logic(export_services_page, 4 + gisAdapterIcio + hover_cell_trash -\r\n            sessionWysiwygWindows);\r\n\r\n## Non sit negat huic vana femina non\r\n\r\nMero loquerentur i uterque inmensum volucres veros exigite frustra cuius, disci\r\ninane callem eversae, odisse. Ulla tuorum res: *sunt licet*, decipiat in tandem.\r\nFidem hunc est aris Hylen Nereius, gravidis primasque cognitus reddita at\r\nprofuit, a.\r\n\r\nArboribus eram, obstantis simul Meropisque flammas, tibi longa tuorum videntur.\r\nObsceno tot veneni fila prope exarsit quotiens semel, pedibus ferat. Una scelus\r\nerrare, unda est decepto, vix putat acrior dissimiles fugavi.\r\n\r\n    flashMailHdtv = serverShiftMashup;\r\n    if (session_excel + errorIrq) {\r\n        commerce_t += userDtdWww(integrated_down, spooling_interlaced,\r\n                macintosh);\r\n    } else {\r\n        exif_zip_barcraft.vectorFile += virtual_lock_card;\r\n        manetNvramScareware = soft.click(midi_torrent_gigaflops(\r\n                bandwidth_finder_fragmentation));\r\n    }\r\n    managementDacApple += bitmapService.bps(youtube_yahoo_boolean + of,\r\n            bootNewbie + menu_page_desktop, 82 + 82);\r\n    mebibyte_speed += asp_uddi_keywords;\r\n    if (del) {\r\n        intellectual -= 415357;\r\n        server(parity_file_white * web_bit);\r\n    } else {\r\n        digitalCommercialTypeface.richMicrophone = 1;\r\n        power += key;\r\n    }\r\n\r\nFama et *ocius alis* rebar iam, quo vertatur Aonias, pedes, potiatur imo, sum\r\nseptem furentem. Erat adeo umero in ille, sustinui, aspicite et medio *primoque*\r\nmediis; humanaeve repulsae, pro. Deus fortissime ad erat ministris cortice\r\nsolacia quod aequora [minus clademque](http://www.flumineaeoris.com/alvo.html) e\r\nCinyrae censu quid aper quae pericula [ferventi](http://foribus.net/saepe).\r\nHiatu quae fortunam Cipus quae gaudent rupti per Rex; non **sola arma labore**\r\nmendosa! Ante memoremque tua, ecce et, est qua sumpta viaeque: hoc nomina ante.\r\n\r\nInnixamque Argosque relatus forte et paulatim sensibus turpes colubriferi\r\nsustinet, tela. Athin Iapeto dum metam parenti, ab fuit; favus. Fons adhibet\r\nsignificent vultus puerum qua quem iram nepotum! Onus iam culpa et locorum plebe\r\npatruelibus possit!'), 1, 'Chapitre 1 : Les bases', 3),
(7, STRINGDECODE('# Fortuna fluentia auxilium elementa certior Cecropios iunxit\r\n\r\n## Videntur tacitos\r\n\r\nLorem markdownum ipsa, ecce licet quibus respiramina: pudici ages averso virga\r\ntu credis fata iurasse. Iunone offensa, hos auratis auctor si ad nullo lugubris:\r\net. Lecte forabilis dedit consequitur ut aer venisset nec aequor caedis ire\r\ntemplisque.\r\n\r\n    var website_passive_view = stick_graphic * workstationNewlineFlash +\r\n            snapshot(1, 3) * caps;\r\n    cpu(mask);\r\n    restoreServer.operation_e(videoUps + modifier - dvd_native, tokenDramCycle,\r\n            dll.wpa_seo_hardening.dnsWebmail(name));\r\n    var skyscraper_task = onlyUnmountService(snapshotCarrierArt(\r\n            dma_rosetta_internet, softwareRdram, oopFile), pop) -\r\n            type_graphic.cifs.mirrored_it(\r\n            myspaceLayout.imDvd.smartphoneCadOffline(fiAddIeee, 58),\r\n            file_wavelength, sata_address);\r\n    var dmaMotherboard = extranet;\r\n\r\n## Et gratam\r\n\r\nIacet sic possem sed, cur potes sagitta est quamquam opemque sanguine\r\n[possedit](http://www.armis-non.io/cruor-quicquid.html). Foret viri solari\r\nformam aliquid comitate curae sparsus faciemque omnia gemuere. **Adimam nil**\r\nsupplex solque sub nymphae haud.\r\n\r\nNec Apolline Neve agilis protinus in inter retenta populisque cuncta?\r\nConloquiumque coepit caespite ex **fronte** vocabitur cruore crescere puer\r\ncreverat! Leto caterva Latinas Theseius Luna; in in quam et Chirona? Copia\r\nfraternaque carcere.\r\n\r\n## Recumbere sole quantusque noxae\r\n\r\nIamque colle, *vera dum cultus*? Tantum cum fratrem redeamus: a Tydides torva\r\ninque pars est ignibus pleno. En senumque disiecit habet! Forma quos fuerant\r\nexsistere illa tenent pondus tribus non auditur Peneiaque materna!\r\n\r\n    autoresponderLion -= bitmapDirect(soft_version_dvd, ssid, 2) + dbms_desktop\r\n            + busCapsPersonal(sync_memory_desktop, 96, kernelLink) +\r\n            basic_vertical;\r\n    if (3) {\r\n        refreshWebcamIcon += waveform_postscript;\r\n    }\r\n    if (hypertextLeaf + flashDma - disk) {\r\n        null /= degauss;\r\n    }\r\n    alu_bus(gif / rdram);\r\n    variable.default_dbms = ugc;\r\n\r\nTerritus fluctus Lyaeus. Tectus isto, iam niteant parte. Negat aera umbra,\r\nresolutaque dissociata retinere *nescia et trahenti* anguiferumque terga illis\r\nclivo, dent *et calathis*. Memoro ei atque maius hostibus tenuata parentis\r\ngaudet sua est laurea petunt tune; sua est nam luce, vigilantibus. Fratres et\r\ncuncta ad quos et pariter munere; de arma, et herbas fugit, morboque.\r\n\r\nTenet pro erigor minas pennis **habitataque magna** anser ponat, vidi audit\r\nfluet steterant inposuit rursus bene transit Herculeae. Utroque nisi vulnera\r\nsubiectos ad quibus adloquitur templa exclamant postes bulla. Ferinos *vocati\r\nproxima ferox*; caelo generosa exilio disponunt mucrone, deducit nec concha\r\nmecum, ex tenent nova [pati](http://www.medullas-suumque.net/dabat-remos.html).\r\nQuid inque adhaerent vocavit Paridis tempora distinguunt quem populus urnae.\r\nErigitur spicula.'), 2, 'Chapitre 2 : Un peu plus loin', 3);    
--MCT
INSERT INTO PUBLIC.MCT(ID, SHOWANSWERS, SUCCESSCONDITION, CHAPTER_ID) VALUES
(1, FALSE, 2, 1),
(2, FALSE, 1, 2),
(3, FALSE, 3, 3),
(4, FALSE, 0, 4),
(5, FALSE, 2, 5),
(6, FALSE, 1, 6),
(7, FALSE, 2, 7);

--QUESTION
INSERT INTO PUBLIC.QUESTION(ID, QUESTIONTEXT, MCT_ID) VALUES
(1, '8+8', 1),
(2, '2+2', 1),
(3, '16+16', 2),
(4, '9+9', 3),
(5, '2+2', 3),
(6, '8+8', 3),
(7, '12+12', 3),
(8, '5+5', 4),
(9, '5+5', 5),
(10, '7+7', 5),
(11, '4+4', 6),
(12, '7+7', 7),
(13, '1+1', 7);  
--ANSWER
INSERT INTO PUBLIC.ANSWER(ID, ISTRUE, TEXT, QUESTION_ID) VALUES
(1, TRUE, '16', 1),
(2, FALSE, '12', 1),
(3, FALSE, '13', 1),
(4, TRUE, '4', 2),
(5, FALSE, '5', 2),
(6, TRUE, '4', 2),
(7, FALSE, '7', 2),
(8, TRUE, '32', 3),
(9, FALSE, '8', 3),
(10, FALSE, '9', 3),
(11, TRUE, '18', 4),
(12, FALSE, '12', 4),
(13, FALSE, '13', 4),
(14, FALSE, '0', 4),
(15, TRUE, '4', 5),
(16, FALSE, '9', 5),
(17, FALSE, '8', 5),
(18, FALSE, '1', 5),
(19, TRUE, '16', 6),
(20, FALSE, '9', 6),
(21, FALSE, '4', 6),
(22, FALSE, '0', 6),
(23, FALSE, '6', 7),
(24, TRUE, '24', 7),
(25, FALSE, '21', 7),
(26, TRUE, '10', 8),
(27, FALSE, '11', 8),
(28, FALSE, '12', 8),
(29, FALSE, '8', 9),
(30, TRUE, '10', 9),
(31, FALSE, '15', 9),
(32, FALSE, '11', 9),
(33, TRUE, '14', 10),
(34, FALSE, '8', 10),
(35, FALSE, '2', 10),
(36, FALSE, '2', 11),
(37, TRUE, '8', 11),
(38, FALSE, '4', 12),
(39, TRUE, '14', 12),
(40, FALSE, '7', 12),
(41, TRUE, '2', 13),
(42, FALSE, '7', 13),
(43, FALSE, '0', 13);       

--ATTEMPT

INSERT INTO PUBLIC.ATTEMPT(ID, DATE, SCORE, MCT_ID, STUDENT_LOGIN) VALUES
(1, TIMESTAMP '2016-12-15 15:22:21.472', 2, 1, 'student1'),
(2, TIMESTAMP '2016-12-15 15:22:44.188', 2, 1, 'student2'),
(3, TIMESTAMP '2016-12-15 15:22:53.249', 0, 2, 'student2'),
(4, TIMESTAMP '2016-12-15 15:22:55.435', 0, 2, 'student2'),
(5, TIMESTAMP '2016-12-15 15:22:57.806', 1, 2, 'student2'),
(6, TIMESTAMP '2016-12-15 15:23:06.786', 3, 3, 'student2'),
(7, TIMESTAMP '2016-12-15 15:26:24.244', 0, 6, 'student2');      


