import {Injectable} from '@angular/core';
import {HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {environment} from './environment';


@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const basicAuth = 'Basic ' + btoa(environment.authUser + ':' + environment.authPass);
    const authReq = req.clone({
      setHeaders: {
        Authorization: basicAuth
      }
    });

    return next.handle(authReq);
  }
}
