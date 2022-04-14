import {ColaboradorCompetenciaNivelModel} from "./colaborador-competencia-nivel.model";

export class ColaboradorPostModel {

    nome: string;
    sborenome: string;
    cpf: string;
    email: string;
    data_nasc: Date;
    data_admi: Date;
    idSenioridade: number;
    competencias: ColaboradorCompetenciaNivelModel[]

}

